import os
import re

# --- 配置区 ---
EXCLUDED_ITEMS = {".git", ".vscode", "scripts", "README.md", "generate_readme.py", "README_TEMPLATE.md", "__pycache__"}
# --- 配置区结束 ---

def extract_method_from_filename(filename):
    """从文件名中提取解题方法，直接使用Solution_后面的部分"""
    # 移除文件扩展名
    name_without_ext = os.path.splitext(filename)[0]
    
    # 提取Solution_后面的部分
    match = re.search(r'Solution_(.+)', name_without_ext)
    if match:
        method_name = match.group(1)
        # 将下划线替换为空格并首字母大写
        return method_name.replace('_', ' ').title()
    
    # 如果没有Solution_前缀，使用整个文件名
    return name_without_ext.replace('_', ' ').title()

def get_solution_files(problem_folder_path):
    """获取一个题目文件夹下所有的解题文件链接，显示具体方法"""
    files_md = []
    try:
        for file_name in sorted(os.listdir(problem_folder_path)):
            if file_name in EXCLUDED_ITEMS:
                continue
            
            # 提取语言后缀和解题方法
            language_ext = os.path.splitext(file_name)[1].replace(".", "")
            language_map = {
                "py": "Python", "java": "Java", "cpp": "C++", 
                "js": "JavaScript", "ts": "TypeScript", "go": "Go",
                "c": "C", "rs": "Rust"
            }
            language_display = language_map.get(language_ext, language_ext.upper())
            
            method = extract_method_from_filename(file_name)
            
            relative_path = os.path.join(problem_folder_path, file_name).replace("\\", "/")
            # 显示格式：语言(方法)
            files_md.append(f"[{language_display}({method})]({relative_path})")
    except OSError as e:
        print(f"无法读取文件夹 {problem_folder_path}: {e}")
    
    return ", ".join(files_md)

def main():
    print("🚀 开始生成 README...")
    
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

                all_rows.append((
                    problem_num,
                    f"| {problem_num_str} | {problem_title_md} | {solution_links_md} | | |"
                ))

    all_rows.sort(key=lambda x: x[0])
    table_content_md = "\n".join([row[1] for row in all_rows])
    
    try:
        with open("README_TEMPLATE.md", "r", encoding="utf-8") as f:
            readme_template = f.read()
    except FileNotFoundError:
        print("❌ 错误: 找不到 README_TEMPLATE.md 模板文件")
        return

    # 使用占位符替换
    if "{{TABLE_CONTENT}}" in readme_template:
        final_readme = readme_template.replace("{{TABLE_CONTENT}}", table_content_md)
    else:
        # 向后兼容：如果没有占位符，使用原来的替换方式
        final_readme = readme_template.replace("", table_content_md)
    
    with open("README.md", "w", encoding="utf-8") as f:
        f.write(final_readme)
        
    print(f"✅ 成功生成 README！共处理了 {len(all_rows)} 道题目。")

if __name__ == "__main__":
    main()