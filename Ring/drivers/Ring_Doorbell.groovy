/**
 *  Ring Doorbell
 *
 *  Copyright 2019 Dominick Meglio
 *
 */
metadata {
    definition (name: "Ring Doorbell", namespace: "ring", author: "Dominick Meglio") {
		capability "Momentary"
		capability "Motion Sensor"
		
		command "record"
    }

}

def record() {
	parent.handleRecord(device, device.deviceNetworkId.split(":")[1])
}