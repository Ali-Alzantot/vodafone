**Vodafone task**.

#running steps
1- first you must run the scripts under resources folder
2- main class: com.example.task.app.TaskApplication
3- prfile: --spring.profiles.active=local

## Main frameworks
- Spring boot
- JPA
- Lombok
- MapStruct

## Modules
- repository
Contains all the communications to the internal database
- service
Contains all the business logic
- models
Contains all the shared classes between all modules (exceptions, common models)
-rest
Contains all the Rest APIs (Resources)

#Avaliaable resources
Returns an ordered result of devices available for sale
method : get
url : http://localhost:4402/devices/ready
Returns all devices in the warehouse that are waiting for activation.
method : get
url : http://localhost:4402/devices/waiting
update device status
method : put
url : http://localhost:4402/devices/{deviceId}/status/{statusId}
delete device
method : delete
url : http://localhost:4402/devices/{deviceId}