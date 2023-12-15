import subprocess
import os
from termcolor import colored

def run_command(command):
    try:
        if command.startswith("cd "):
            # Handle cd command separately
            new_directory = command[3:].strip()
            try:
                os.chdir(new_directory)
                dir = subprocess.run("pwd", stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, shell=True) 
                dir = dir.stdout.strip()
                return dir,f"Changed directory to: {new_directory}"
            except OSError as cd_error:
                dir = subprocess.run("pwd", stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, shell=True) 
                dir = dir.stdout.strip()
                return dir,f"Error changing directory: {cd_error}"
            return dir,f"Changed directory to: {new_directory}"
        else:
            result = subprocess.run(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, shell=True)
            dir = subprocess.run("pwd", stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, shell=True) 
            dir = dir.stdout.strip()
            if(command.startswith("mkdir ")):
                return dir,"created new directory ..."
            elif result.returncode == 0:
                if(len(result.stdout.strip())!=0):
                    return dir,result.stdout.strip()
                return dir,"No Output"
            else:
                return  dir,f"Error: {result.stderr.strip()}"
    except Exception as e:
        return dir,f"Exception: {str(e)}"

