import yaml

with open("./6b_serializacja/netplan.yaml") as file:
    data = yaml.load(file, Loader=yaml.FullLoader)

for i in range(len(data["network"]["ethernets"]["enp0s25"]["nameservers"]["addresses"])):
    if data["network"]["ethernets"]["enp0s25"]["nameservers"]["addresses"][i] == "192.168.1.1":
        data["network"]["ethernets"]["enp0s25"]["nameservers"]["addresses"][i] = "8.8.8.8"

with open("./6b_serializacja/netplan_new.yaml", "w") as file:
    yaml.dump(data, file)
