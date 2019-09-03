/**
 *  Virtual Garage Door Manager
 *
 *  Copyright 2017 Patrick McKinnon
 *  Copyright 2017 D Canfield
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
 *  Hubitat Port, Parent/Child Mods: D Canfield (peng1can@gmail.com)
 */

definition(
    name: "Virtual Garage Door Manager",
    namespace: "peng1can/parent",
    author: "peng1can@gmail.com",
    description: "Manages Instances of 'Virtual Garage Door' (Parent App)",
    category: "Convenience",
	singleInstance: true,
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/garage_contact.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/garage_contact@2x.png"
)


preferences {
    page(name: "mainPage", title: "Garge Doors", install: true, uninstall: true) {
        section {
            app(name: "virtualGarageDoor", appName: "Virtual Garage Door", namespace: "peng1can", title: "New Garage Door", multiple: true)
        }
    }
}
