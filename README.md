
# Meal App
- Developer: Likhona Ngwenya
- Student Number: ST10446272
- Group: GR01
- Course: Higher Certificate in Mobile Application and Web Development (HMAW0501)
- Subject: IMAD5112

# Links
- GitHub - https://github.com/VCSTDN2024/imad5112-practicum-2025-ST10446272/edit/main/README.md


# Project Overview
The Music App is a mobile application developed as part of an exam assignment in the IMAD5112 subject. This application was created using Kotlin and Android Studio. The app's primary development of this app for music listeners to log in the music they have been listening to the song title the artist name how much to they rate that specific song in simple terms creating a music playlist allowing the user to manage that specific playlist . The app was developed to meet the requirements of the assignment, which includes creating a functional mobile app and utilizing GitHub for version control and CI/CD automation using GitHub Actions.

# App Purpose:
The main goal of this app is to help to user create and manage a playlist.

## App Peseudocode
Rhythm Wave

Pseudocode 

0. Start  

1. 	if btnStart is clicked then 
		InputActivity()
	endif 

2.	if btnExit is clicked then 
		ExitApp()

	endif 
=============================================
0. Start 
1. Declarations 
	string strSong 
	string strArtist
	num intRatings
	string strComments
	intCount 


2. intCount = 0 
3. maxEntries = 4

4. output "Please Enter the name of the song"
5. input strSong 

6. output "Please Enter the name of the artist"
7. input strArtist

8. output "Please Rate the song from 1 to 5"
9. input intRatings

10. output "Please add a comment"
11. input strComment

12. 	if intSong = null or inArtist = null or inRating = null or strComments = null then
		output "Error"
		return //Kick me out of the loop 
	endif

13. 	intCount = intCount + 1
14. 	strSong[intCount] = song 
15.	strArtist[intCount] = artist 
16.	intRatings[intCount] = ratings
17. 	strComent[intCount] = comment 

18. calcAverage()
19. displayAll()

=====================================
0. start 
1. Retrive data from the arrays
2. populate the arrays 
3. output TextView
4. if back button is clicked then 
	go back to inputScreen
	finish()

    endif

==================================== 

 

# Screenshots 
## App Screenshots - User InterFace
Screenshot 1: StartActivity.kt ![Screenshot 2025-06-19 133059](https://github.com/user-attachments/assets/3c13e20f-2a7d-4eb2-8791-bbdb910a8156)
Screenshot 2: InputActivit.kt ![Screenshot 2025-06-19 133126](https://github.com/user-attachments/assets/53d9ff3f-b59d-4c89-a539-e8bb0be4d191)
Screenshot 3: ViewActivity.kt ![Screenshot 2025-06-19 133153](https://github.com/user-attachments/assets/dfe95eac-ba83-403c-bd86-6b94c69b6ea9)


## App ScreenShots:
### Detail View
1. ![Screenshot 2025-06-19 133932](https://github.com/user-attachments/assets/086ca196-10ad-4075-b0a7-62a7fd343100)
2. ![Screenshot 2025-06-19 133947](https://github.com/user-attachments/assets/09ae4157-8561-46a3-b7fb-8da9dea210ca)
3. ![Screenshot 2025-06-19 133956](https://github.com/user-attachments/assets/3216e032-cf78-4514-b532-9156b74c5c66)

### Input  View
1. ![Input 1](https://github.com/user-attachments/assets/10a84d95-2ee8-4c7b-bafb-ffe42507cf9f)
2. ![Input 2](https://github.com/user-attachments/assets/2a1f25c4-5fd0-49cd-9dba-befa2ec918d5)
3. ![Input 3](https://github.com/user-attachments/assets/7991e90d-9bda-480d-98e5-13bc819e356a)
4. ![Input 4](https://github.com/user-attachments/assets/5095a20c-b43d-413c-903a-a775623b53e3)
5. ![Input 5](https://github.com/user-attachments/assets/a200f1b3-b82c-4dc7-9424-354b3a8460c9)
6. ![Input 6](https://github.com/user-attachments/assets/d1d98c12-9cd0-47d3-b0a4-f25ebce03d26)
7. ![Input 7](https://github.com/user-attachments/assets/142efa13-9cdf-4e6c-b4d4-89c17047fbb9)

### Splash View
1. ![Splash 1](https://github.com/user-attachments/assets/a4519225-a12b-4e0c-ac0e-aa4927de2e73)

### Start View
1. ![Start 1](https://github.com/user-attachments/assets/729a373a-667d-4d40-b381-e01cb634c816)



## App Flow
#### Desiging the User InterFace 
### WireFrame
-![image](https://github.com/user-attachments/assets/8ebdea09-582a-46b1-9a7e-081aaa3e8fab)


### Navigation Flow
1. Splash Screem - Screen 1
2. Start Screen - Screen 2
3. Input Screen - Screen 3
4. View Screen - Screen 4

### Screen 1 - Splash Screem 
Logo

### Screen2 - Start Screen
App Name -> Student Name -> ST Number -> Logo -> Start -> Exit

### Screen 3 -  Input Screen
App Name -> Song Title - Edit Text -> Artist - Edit Text -> Rating - Radio Group -> Comments - Edit Text ->
.....
Button - add -> Button - clear -> Button - view Details -> Button - Exit ->

### Screen 4 - View Screen
App name ->
Button - Display all -> Button - Display Average -> Text View - "Display Content" -> Button - Back -> Button - Exit ->





## References

1. Reference 1: https://za.pinterest.com/pin/2814818511609742/



