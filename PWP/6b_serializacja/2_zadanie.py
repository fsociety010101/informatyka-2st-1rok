import urllib.request
import json

request = urllib.request.Request(
    url="https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=51.25&lon=22.57",
    data=None,
    headers={
        "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.1 Safari/605.1.15"
    },
)

response = urllib.request.urlopen(request)
data = json.loads(response.read())
print(
    "Weather forecast for Lublin:\nTempetature: ",
    data["properties"]["timeseries"][0]["data"]["instant"]["details"]["air_temperature"],
    "\nPressure: ",
    data["properties"]["timeseries"][0]["data"]["instant"]["details"]["air_pressure_at_sea_level"],
)
