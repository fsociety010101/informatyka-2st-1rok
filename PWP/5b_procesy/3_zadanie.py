import os
import subprocess

list_success = []
list_fail = []

for file in os.listdir("./scripts"):
    if file.endswith(".py"):
        result = subprocess.run(["python3", "./scripts/" + file], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        if result.stderr:
            list_fail.append(file)
        else:
            list_success.append(file)

print("Success: ", list_success)
print("Fail:    ", list_fail)
