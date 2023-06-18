import subprocess

dirStr = """
K1
_K2
_K3
__K4
K5
_K6
"""

prev = ""
prev2 = ""
for it in dirStr.splitlines():
    if it.startswith("__"):
        out = subprocess.run(["mkdir", "." + prev2 + "/" + it], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    elif it.startswith("_"):
        out = subprocess.run(["mkdir", "." + prev + "/" + it], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        prev2 = prev + "/" + it
    elif it.startswith("K"):
        out = subprocess.run(["mkdir", "." + it], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        prev = it
