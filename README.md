## COMMUNICATION MEDIUM FOR HEARING IMPAIRED
 Android application for deaf
 
## Problem Statement
To help hearing impaired people by using speech recognition technology making them communicate with others more easily.

## Abstract
There are lot of deaf people who face lot of struggles and difficulties in communicating with others in daily life. Already available helping aids are not upto the mark when considering few parameters. This system proposes an approach for getting immediate attention to deaf people by vibrating their smartphone when calling upon their name. There is also an option for speech to text conversion where the can let the other person to speak and have it displayed as a text. There is also a space given to the other person where he can input a text message and show it the user. Hearing aids are also not that efficient and not sure to work in all the cases. In an emergency this may come in handy without any other requirements. A regular smartphone is enough which can be seen with everyone today. The input is given through the microphone which is compared with the already provided name, if match, then it vibrates for tactile intimation. The application also provides video calling feature. The user is provided with an instant speech to text conversion under the video feed similar to subtitles enabling the user to make video calls as any normal person does.

## Modules

    - Speech-to-text [Gayathri.M]
    - Vibration feedback [Manishaa.k]
    - Video Calling with subtitles [Balaji.V]

## Speech-to-text

The option is speech to text conversion where they can let the other person to speak and have it displayed as a text. In that we are using Google speech recognition API which is also called speech recognizer intent. This API is provided in the Android as a default API so the speech-to-text feature works offline. The voice input by the other person is given to the API and then it is converted and displayed as text. So the deaf people can understand what the other person is speaking. This does not require any data connection. It works fine in offline. However we need data connection for accurate results.

## Vibration Feedback

These applications have the feature that if someone calls the name of the user then it vibrates. So the user can easily identify if someone is calling behind them. The user name is saved into the application and then the input is given through the microphone which is compared with the already provided name, if match, then it vibrates for tactile intimation. For the vibration the application should run all the time in the background. For this also we are using speech to text intent API which gets the name and convert it into text and then compare it with the saved name. If the name matches with the already provided name then the mobile will vibrates.
 
## Video calling with subtitles

Video calling feature is included in this application. While the other user speaks it the voice is converted to text and it is displayed at the bottom of the video feed similar to subtitles. So the user can use this feature to communicate with the normal person easily without any bother. For this video calling we are using Sinch API which is provided as PaaS (Platform as a service). Sinch offers software development kits (SDKs) for Video Calling that you integrate with your mobile or web application for easily adding video calling features. Video calling is supported on ios, Android, JavaScript SDK and video calls can be placed seamlessly across the three platforms. The Sinch SDK is a cloud-based product that allows developers easily add video calling to the mobile apps.

## Project Status

    Speech-to-text (Working Successfully)
    Vibration Feedback (Working Successfully)
    Video calling with subtitles (75% completed)
    
 ## Future Enhancement
 
 Perfect syncing of video and voice-to-text conversion may not be possible with the available technologies. It is believed that with rapid growth of technology in this information age and developing technologies like 5G and Quantum computing, instant voice conversion will be available in near future. 
