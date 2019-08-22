/**
 *  Ring Battery Camera
 *
 *  Copyright 2019 Dominick Meglio
 *
 */
metadata {
	definition (name: "Ring Battery Camera", namespace: "ring", author: "Dominick Meglio") {
		capability "Light"
		capability "Refresh"
		capability "Motion Sensor"
		capability "Battery"
		capability "Alarm"
		
		command "record"
	}
}

def on() {
	parent.handleOn(device, device.deviceNetworkId.split(":")[1])
}

def off() {
	parent.handleOff(device, device.deviceNetworkId.split(":")[1])
}

def siren() {
	parent.handleSiren(device, device.deviceNetworkId.split(":")[1])
}

def strobe() {
	parent.handleStrobe(device, device.deviceNetworkId.split(":")[1])
}

def record() {
	parent.handleRecord(device, device.deviceNetworkId.split(":")[1])
}

def both() {
	parent.handleBoth(device, device.deviceNetworkId.split(":")[1])
}

def refresh() {
	parent.handleRefresh()
}
