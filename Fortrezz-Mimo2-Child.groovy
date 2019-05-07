/**
 *  FortrezZ MIMO2+ B-Side
 *
 *  Copyright 2016 FortrezZ, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 * Version 1.1 - 5/3/19
 * Basic Port from SmartThings
 * Can you port a driver that it just a glorified TODO list?
 * 
 * Version 1.2 - 5/6/19 - peng1can
 * Very basic but working b-side child driver.
 *
 */
metadata {
	definition (name: "FortrezZ MIMO2+ B-Side", namespace: "fortrezz", author: "FortrezZ, LLC") {
		capability "Contact Sensor"
		capability "Relay Switch"
		capability "Switch"
		capability "Voltage Measurement"
        capability "Refresh"
	}
    
	tiles {
         standardTile("switch", "device.switch", width: 2, height: 2) {
            state "on", label: "Relay 2 On", action: "off", backgroundColor: "#53a7c0"            
			state "off", label: "Relay 2 Off", action: "on", backgroundColor: "#ffffff"
        }
        standardTile("anaDig1", "device.anaDig1", inactiveLabel: false) {
			state "open", label: '${name}', backgroundColor: "#ffa81e"
			state "closed", label: '${name}', backgroundColor: "#79b821"
            state "val", label:'${currentValue}v', unit:"", defaultState: true
		}
        standardTile("refresh", "device.switch", inactiveLabel: false, decoration: "flat") {
			state "default", label:'', action:"refresh.refresh"
		}
        standardTile("powered", "device.powered", inactiveLabel: false) {
			state "powerOn", label: "Power On", backgroundColor: "#79b821"
			state "powerOff", label: "Power Off", backgroundColor: "#ffa81e"
		}
		standardTile("configure", "device.configure", inactiveLabel: false, decoration: "flat") {
			state "configure", label:'', action:"configuration.configure"
		}
        standardTile("blank", "device.blank", inactiveLabel: true, decoration: "flat") {
        	state("blank", label: '')
        }
		main (["switch"])
		details(["switch", "anaDig1", "blank", "blank", "refresh", "powered"])
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'contact' attribute
	// TODO: handle 'switch' attribute
	// TODO: handle 'switch' attribute
	// TODO: handle 'voltage' attribute

}

def eventParse(evt) {
	log.debug("Event: ${evt.name}=${evt.value}")
    switch(evt.name) {
    	case "powered":
        	sendEvent(name: evt.name, value: evt.value)
        	break
    	case "switch2":
        	sendEvent(name: "switch", value: evt.value)
        	break
    	case "contact2":
        	sendEvent(name: "contact", value: evt.value)
        	break
    	case "voltage2":
        	sendEvent(name: "voltage", value: evt.value)
        	break
    	case "relay2":
        	sendEvent(name: evt.name, value: evt.value)
        	break
    	case "anaDig2":
        	sendEvent(name: "anaDig1", value: evt.value)
        	break
    }
}

// handle commands
def on() {
    parent.on2()
	log.debug("Executing 'on'")
}

def off() {
	parent.off2()
	log.debug("Executing 'off'")
}
def refresh() {
	parent.refresh()
    log.debug("Executing 'refresh'")
}
