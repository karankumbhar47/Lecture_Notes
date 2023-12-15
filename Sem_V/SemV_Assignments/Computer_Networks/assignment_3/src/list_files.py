import subprocess

def listFiles():
    files = subprocess.run("ls ../dataset/", stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, shell=True)
    filesList = files.stdout.strip()
    return filesList

def filePath(fileName):
    files = listFiles()
    lines = files.splitlines()
    for file in lines:
        if file == fileName:
            return "../dataset/"+fileName
        else:
            return -1
