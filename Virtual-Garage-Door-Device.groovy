/**
 *  Virtual Garage Door
 *
 *  Copyright 2017 Patrick McKinnon
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
 *  Original Author: Patrick McKinnon (patrick@ojolabs.com)
 *  Hubitat patches from @stephack, @peng1can
 */
metadata {
    definition (name: "Virtual Garage Door", namespace: "peng1can", author: "peng1can@gmail.com") {
        capability "Actuator"
        capability "Door Control"
		capability "Contact Sensor" //added for HE dashboard
        capability "Garage Door Control"
        capability "Switch"

        command "setVirtualGarageState"
    }

    simulator {

    }

    tiles {
        standardTile("toggle", "device.door", width: 2, height: 2) {
            state("closed", label:'${name}', action:"door control.open", icon:"st.doors.garage.garage-closed", backgroundColor:"#79b821", nextState:"opening")
            state("open", label:'${name}', action:"door control.close", icon:"st.doors.garage.garage-open", backgroundColor:"#ffa81e", nextState:"closing")
            state("opening", label:'${name}', icon:"st.doors.garage.garage-closed", backgroundColor:"#ffe71e")
            state("closing", label:'${name}', icon:"st.doors.garage.garage-open", backgroundColor:"#ffe71e")

        }
        standardTile("open", "device.door", inactiveLabel: false, decoration: "flat") {
            state "default", label:"open", action:"door control.open", icon:"st.doors.garage.garage-opening"
        }
        standardTile("close", "device.door", inactiveLabel: false, decoration: "flat") {
            state "default", label:"close", action:"door control.close", icon:"st.doors.garage.garage-closing"
        }

        main "toggle"
        details(["toggle", "open", "close"])
    }
}

def open() {
    log.debug "open()"
    sendEvent(name: "switch", value: "on")
	sendEvent(name: "contact", value: "open")  //added for HE dashboard
}

def close() {
    log.debug "close()"
    sendEvent(name: "switch", value: "off")
	sendEvent(name: "contact", value: "closed")  //added for HE dashboard
}

def setVirtualGarageState(config) {
    log.debug("setVirtualGarageState($config)")
    sendEvent(name: "door", value: config["door"])
    if(config["door"] == "open") {
        sendEvent(name: "switch", value: "on")
		sendEvent(name: "contact", value: "open") //not sure how this is used by app but added here because I assume it would be needed
    }
    else if(config["door"] == "closed") {
        sendEvent(name: "switch", value: "off")
		sendEvent(name: "contact", value: "closed") //not sure how this is used by app but added here because I assume it would be needed
    }
}
