import subprocess

# u mnie z "shell = True" nie działa
out_ok = subprocess.run(["ls", "."], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
print("---")
print(out_ok)
print("---")
print("return code: %s" % (out_ok.returncode))
print("stdout: %s" % (out_ok.stdout))
print("stderr: %s" % (out_ok.stderr))

out_err = subprocess.run(["ls", ".!%"], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
print("---")
print(out_err)
print("---")
print("return code: %s" % (out_err.returncode))
print("stdout: %s" % (out_err.stdout))
print("stderr: %s" % (out_err.stderr))
