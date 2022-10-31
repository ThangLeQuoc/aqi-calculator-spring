# Spring Boot AQI Calculator

The [Java AQI Calculator](https://github.com/ThangLeQuoc/aqi-calculator) as the REST API Spring Boot application to make it easy to start and run.

# Installation
Checkout the code  
Inside the project root, run
>./gradlew bootRun


# For Docker user (strongly recommended)
Fear of Java, Spring Boot, or maybe you're just too lazy to install them.  
With [Docker](https://www.docker.com/), it's super easy to get the container up and running without installing Java on your local machine. You don't need to know Java or Spring  
Give it a go:  
> docker pull thanglequoc/aqi-calculator-spring-boot:latest

The container application port is **8080**, you will need to [map your host port to the port](https://docs.docker.com/config/containers/container-networking/) **8080** of the container

Run the container with a specified port on your machine (e.g: 8080) to the application port **8080**
> docker run --name=aqi-calculator -p 8080:8080 thanglequoc/aqi-calculator-spring-boot

# Usage
## Calculate regular AQI
Calculate the [regular AQI]([https://github.com/ThangLeQuoc/aqi-calculator#calculation-formula](https://www.airnow.gov/aqi/aqi-calculator-concentration/)) of the pollutant with the given concentration
**Request**  
Method type: `POST`  
URL: http://localhost:8080/aqi-calculator/aqi  
Request Body (content-type: JSON)
```json
{
    "pollutant": "PM25",
    "concentration": 245
}
```
| Parameter     | Type   | Detail                                                                                                                                                                                                                    |
|---------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| pollutant     | String | The pollutant. See list of available pollutant                                                                                                                                                                            |
| concentration | double | The concentration of this pollutant. The unit: For PMs is μg/m3, for the rest is ppb. See [here for more detail](https://github.com/ThangLeQuoc/aqi-calculator#support-the-following-pollutants) |


**Response**
```
{
    "pollutant": "PM25",
    "concentration": 245.0,
    "category": "Very Unhealthy",
    "color": "Purple",
    "meaning": "Health alert: everyone may experience more serious health effects",
    "healthEffectsStatements": "Significant aggravation of respiratory symptoms in sensitive groups including older adults, children, and people of lower socioeconomic status; significant aggravation of heart or lung disease and premature mortality in people with heart or lung disease; significant increase in respiratory effects in general population",
    "cautionaryStatements": "People with heart or lung disease, older adults, children, and people of lower socioeconomic status should avoid all physical activity outdoors. Everyone else should avoid prolonged or heavy exertion",
    "sensitiveGroups": "People with respiratory or heart disease, the elderly and children are the groups most at risk",
    "aqi": 295
}
```
See [AQIResult](https://github.com/ThangLeQuoc/aqi-calculator#using-aqiresult-object) to understand about the AQI response result


## Calculate Nowcast AQI

Calculate the [Nowcast AQI](https://www3.epa.gov/airnow/aqicalctest/nowcast.htm)
See [here](https://github.com/ThangLeQuoc/aqi-calculator#nowcast-for-pm-and-ozone) for more detail

**Request**  
Method type: `POST`  
URL: http://localhost:8080/aqi-calculator/nowcast-aqi  
Request Body (content-type: JSON)
```json
{
    "pollutant": "PM25",
    "concentrationsLast12Hours": [
        64, 63, 72, 77, 65, 61, 70, 71, 64, 57, 58, 64
    ]
}
```

| Parameter     | Type   | Detail                                                                                                                                                                                                                    |
|---------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| pollutant     | String | The pollutant. See list of available pollutant                                                                                                                                                                            |
| concentrationsLast12Hours | array of double | The first value in the array is the avg value in the current hour, and each next element in the array represent the previous data of the hour before current hour. If the hour doesn't have data, replace missing data in the hour with **-1**. See [here for further example](https://github.com/ThangLeQuoc/aqi-calculator#for-nowcast-aqi-calculation) |

**Response**
```json
{
    "pollutant": "PM25",
    "concentration": 66.6,
    "category": "Unhealthy",
    "color": "Red",
    "meaning": "Everyone may begin to experience health effects; members of sensitive groups may experience more serious health effects",
    "healthEffectsStatements": "Increased aggravation of respiratory symptoms in sensitive groups including older adults, children, and people of lower socioeconomic status; increased aggravation of heart or lung disease and premature mortality in people with heart or lung disease; increased respiratory effects in general population",
    "cautionaryStatements": "People with heart or lung disease, older adults, children, and people of lower socioeconomic status should avoid prolonged or heavy exertion; everyone else should reduce prolonged or heavy exertion",
    "sensitiveGroups": "People with respiratory or heart disease, the elderly and children are the groups most at risk",
    "aqi": 157
}
```

The `aqi` in the response is the Nowcast AQI  
See [AQIResult](https://github.com/ThangLeQuoc/aqi-calculator#using-aqiresult-object) to understand about the AQI response result.

## List of pollutant available for AQI calculation
| Pollutant | Code   |
|-----------|--------|
| PM10      | `PM10` |
| PM2.5     | `PM25` |
| O3        | `O3`   |
| CO        | `CO`   |
| SO2       | `SO2`  |
| NO2       | `NO2`  |

#### References
See [AQI Calculator repository](https://github.com/ThangLeQuoc/aqi-calculator) for more information
