import subprocess
import os
from datetime import datetime
import re

def check_vim_save(file_path):
    with open(file_path, 'r', encoding='utf-8', errors='ignore') as file:
        file_content = file.read()

        pattern = re.compile(r':[wWqQ]')
        match = pattern.search(file_content)

        if match:
            return True
        else:
            return False
def edit_file_with_vim(file_path,username):
    try:
        # Create a temporary log file to capture Vim's write command
        log_file = "../dataset/myVim.log"

        # Open the file in Vim and write the changes to the log file
        subprocess.run(['vim','-w', log_file, file_path])

        # Check if the log file contains the write command (indicating changes were saved)
        with open(log_file, 'r') as log:
            if check_vim_save(log_file):
                print("Changes were saved.")

                # Get current date and time
                current_datetime = datetime.now()
                # Format the date and time
                formatted_datetime = current_datetime.strftime("%m-%d-%Y [%I:%M %p]")

                # Add new lines to the file
                with open(file_path, 'a') as file:
                    file.write(f"\n==> code added by {username}({formatted_datetime}).")
                return True
            else:
                print("Changes were not saved. Please save the file before exiting.")
                return False

    except Exception as e:
        print(f"Error: {e}")
        return False
    finally:
        # Remove the temporary log file
        if os.path.exists(log_file):
            os.remove(log_file)


# Example usage
file_path = '../dataset/file1.txt'
edit_file_with_vim(file_path,"karan")
