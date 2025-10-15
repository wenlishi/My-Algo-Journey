import os
import re
import json # 1. 导入 json 库

# --- 配置区 ---
EXCLUDED_ITEMS = {".git", ".vscode", "scripts", "README.md", "generate_readme.py", "README_TEMPLATE.md", "__pycache__", "metadata.json"} # 把 metadata.json 也排除
# --- 配置区结束 ---

def load_metadata():
    """加载手动维护的元数据文件"""
    try:
        with open("metadata.json", "r", encoding="utf-8") as f:
            return json.load(f)
    except FileNotFoundError:
        print("💡 未找到 metadata.json 文件，将使用默认值。")
        return {}
    except json.JSONDecodeError:
        print("❌ 错误: metadata.json 文件格式不正确。")
        return {}

def extract_method_from_filename(filename):
    """从文件名中提取解题方法，直接使用Solution_后面的部分"""
    name_without_ext = os.path.splitext(filename)[0]
    match = re.search(r'Solution_(.+)', name_without_ext)
    if match:
        method_name = match.group(1)
        return method_name.replace('_', ' ').title()
    return name_without_ext.replace('_', ' ').title()

def get_solution_files(problem_folder_path):
    """获取一个题目文件夹下所有的解题文件链接，显示具体方法"""
    files_md = []
    try:
        for file_name in sorted(os.listdir(problem_folder_path)):
            if file_name in EXCLUDED_ITEMS:
                continue
            
            language_ext = os.path.splitext(file_name)[1].replace(".", "")
            language_map = {
                "py": "Python", "java": "Java", "cpp": "C++", 
                "js": "JavaScript", "ts": "TypeScript", "go": "Go",
                "c": "C", "rs": "Rust"
            }
            language_display = language_map.get(language_ext, language_ext.upper())
            method = extract_method_from_filename(file_name)
            relative_path = os.path.join(problem_folder_path, file_name).replace("\\", "/")
            files_md.append(f"[{language_display}({method})]({relative_path})")
    except OSError as e:
        print(f"无法读取文件夹 {problem_folder_path}: {e}")
    
    return ", ".join(files_md)

def main():
    print("🚀 开始生成 README...")
    
    # 2. 加载元数据
    metadata = load_metadata()
    default_meta = metadata.get("default", {"difficulty": "", "notes": ""})
    
    all_rows = []
    
    for item_name in sorted(os.listdir(".")):
        if os.path.isdir(item_name) and item_name not in EXCLUDED_ITEMS:
            match = re.match(r'^(\d{1,4})-(.*)$', item_name)
            if match:
                problem_num_str = match.group(1)
                problem_slug = match.group(2)
                
                problem_num = int(problem_num_str)
                problem_title = problem_slug.replace('-', ' ').title()
                
                leetcode_url = f"https://leetcode.com/problems/{problem_slug}/"
                problem_title_md = f"[{problem_title}]({leetcode_url})"
                
                solution_links_md = get_solution_files(item_name)
                
                if not solution_links_md:
                    continue
                
                # 3. 从元数据中获取难度和笔记
                problem_meta = metadata.get(problem_num_str, default_meta)
                difficulty = problem_meta.get("difficulty", "")
                notes = problem_meta.get("notes", "")

                all_rows.append((
                    problem_num,
                    # 4. 构建包含所有信息的完整表格行
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

    # 逻辑修正：确保替换逻辑正确
    if "{{TABLE_CONTENT}}" in readme_template:
         final_readme = readme_template.replace("{{TABLE_CONTENT}}", table_content_md)
    else:
        print("❌ 错误: 模板文件中缺少 {{TABLE_CONTENT}} 占位符。")
        # 如果没有占位符，直接将表格内容附加到末尾，或者报错
        final_readme = readme_template + "\n" + table_content_md
    
    with open("README.md", "w", encoding="utf-8") as f:
        f.write(final_readme)
        
    print(f"✅ 成功生成 README！共处理了 {len(all_rows)} 道题目。")

if __name__ == "__main__":
    main()