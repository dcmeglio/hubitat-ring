# Ring Integration
To use the Ring integration, first install the Ring_Integration app. Next install the Ring_Manager, Ring_Doorbell, Ring_Camera, and Ring_Battery_Camera drivers.

## Configuring Alexa
1. For each Ring device create a routine for Motion Detected
2. Set the routine to set the Ring Manager device to a specific unique dimmer level
3. Repeat the above 2 steps for Doorbell button pushes

## Configure the App
1. Provide your Ring credentials
2. Select the devices you wish to configure for the integration
3. Provide the same dimmer values you specified in the Alexa routine for each setting in the app 

## Quick Summary
Basically, when the Alexa routine occurs, the Ring Manager device will be set to a specific dimmer level. The Ring Integration app will translate this to triggering motion or a button push for the appropriate ring virtual device.

