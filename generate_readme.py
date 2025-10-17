import os
import re
import json
import time
import requests # 导入新库

# --- 配置区 ---
EXCLUDED_ITEMS = {".git", ".vscode", "scripts", "README.md", "generate_readme.py", "README_TEMPLATE.md", "__pycache__", "metadata.json"}
LEETCODE_API_URL = "https://leetcode.com/graphql"
# --- 配置区结束 ---

def get_problem_difficulty(slug):
    """通过 LeetCode API 获取题目难度"""
    try:
        query = {
            "query": """
                query questionTitle($titleSlug: String!) {
                    question(titleSlug: $titleSlug) {
                        difficulty
                    }
                }
            """,
            "variables": {"titleSlug": slug}
        }
        headers = {'Content-Type': 'application/json'}
        response = requests.post(LEETCODE_API_URL, json=query, headers=headers, timeout=10)
        response.raise_for_status() # 如果请求失败则抛出异常
        
        data = response.json()
        difficulty = data.get("data", {}).get("question", {}).get("difficulty")
        if difficulty:
            print(f"✅ 成功获取 '{slug}' 的难度: {difficulty}")
            return difficulty
        else:
            print(f"❓ 未能从 API 获取 '{slug}' 的难度，请检查 slug 是否正确。")
            return "N/A"
            
    except requests.RequestException as e:
        print(f"❌ 请求 LeetCode API 失败: {e}")
        return "N/A"

def load_metadata():
    """加载或初始化元数据文件"""
    if not os.path.exists("metadata.json"):
        return {"default": {"difficulty": "N/A", "notes": ""}}
    try:
        with open("metadata.json", "r", encoding="utf-8") as f:
            return json.load(f)
    except (json.JSONDecodeError, FileNotFoundError):
        return {"default": {"difficulty": "N/A", "notes": ""}}

def save_metadata(metadata):
    """保存元数据到文件，保持格式美观"""
    with open("metadata.json", "w", encoding="utf-8") as f:
        json.dump(metadata, f, indent=2, ensure_ascii=False)

# (extract_method_from_filename 和 get_solution_files 函数保持不变，这里省略)
def extract_method_from_filename(filename):
    name_without_ext = os.path.splitext(filename)[0]
    match = re.search(r'Solution_(.+)', name_without_ext)
    if match:
        method_name = match.group(1)
        return method_name.replace('_', ' ').title()
    return name_without_ext.replace('_', ' ').title()

def get_solution_files(problem_folder_path):
    files_md = []
    try:
        for file_name in sorted(os.listdir(problem_folder_path)):
            if file_name in EXCLUDED_ITEMS: continue
            language_ext = os.path.splitext(file_name)[1].replace(".", "")
            language_map = {"py": "Python", "java": "Java", "cpp": "C++"}
            language_display = language_map.get(language_ext, language_ext.upper())
            method = extract_method_from_filename(file_name)
            relative_path = os.path.join(problem_folder_path, file_name).replace("\\", "/")
            files_md.append(f"[{language_display}({method})]({relative_path})")
    except OSError as e: print(f"无法读取文件夹 {problem_folder_path}: {e}")
    return ", ".join(files_md)
# ---

def main():
    print("🚀 开始处理...")
    
    metadata = load_metadata()
    default_meta = metadata.get("default", {"difficulty": "N/A", "notes": ""})
    metadata_updated = False
    
    all_rows = []
    
    # 扫描文件夹，更新元数据
    print("\n--- 1. 扫描文件夹并更新元数据 ---")
    for item_name in sorted(os.listdir(".")):
        if os.path.isdir(item_name) and item_name not in EXCLUDED_ITEMS:
            match = re.match(r'^(\d{1,4})-(.*)$', item_name)
            if match:
                problem_num_str = match.group(1).zfill(4) # 统一为4位，如 0021
                problem_slug = match.group(2)
                
                # 如果是新题目，则自动添加
                if problem_num_str not in metadata:
                    print(f"✨ 发现新题目: {item_name}，正在获取信息...")
                    difficulty = get_problem_difficulty(problem_slug)
                    metadata[problem_num_str] = {"difficulty": difficulty, "notes": ""}
                    metadata_updated = True
                    time.sleep(1) # 友好请求，避免过快访问 API
    
    # 如果元数据有更新，则保存回文件
    if metadata_updated:
        print("\n💾 检测到元数据更新，正在保存到 metadata.json...")
        save_metadata(metadata)

    # 生成 README
    print("\n--- 2. 生成 README 内容 ---")
    for item_name in sorted(os.listdir(".")):
        if os.path.isdir(item_name) and item_name not in EXCLUDED_ITEMS:
            match = re.match(r'^(\d{1,4})-(.*)$', item_name)
            if match:
                problem_num_str = match.group(1).zfill(4)
                problem_slug = match.group(2)
                
                problem_num = int(problem_num_str)
                problem_title = problem_slug.replace('-', ' ').title()
                
                leetcode_url = f"https://leetcode.cn/problems/{problem_slug}/"
                problem_title_md = f"[{problem_title}]({leetcode_url})"
                
                solution_links_md = get_solution_files(item_name)
                if not solution_links_md: continue
                
                problem_meta = metadata.get(problem_num_str, default_meta)
                difficulty = problem_meta.get("difficulty", default_meta["difficulty"])
                notes = problem_meta.get("notes", default_meta["notes"])

                all_rows.append((
                    problem_num,
                    f"| {problem_num_str} | {problem_title_md} | {solution_links_md} | {difficulty} | {notes} |"
                ))

    all_rows.sort(key=lambda x: x[0])
    table_content_md = "\n".join([row[1] for row in all_rows])
    
    try:
        with open("README_TEMPLATE.md", "r", encoding="utf-8") as f:
            readme_template = f.read()
    except FileNotFoundError:
        print("❌ 错误: 找不到 README_TEMPLATE.md 模板文件")
        return

    final_readme = readme_template.replace("{{TABLE_CONTENT}}", table_content_md)
    
    with open("README.md", "w", encoding="utf-8") as f:
        f.write(final_readme)
        
    print(f"\n✅ 成功生成 README！共处理了 {len(all_rows)} 道题目。")

if __name__ == "__main__":
    main()