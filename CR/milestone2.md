<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Sajid Chowdhury (shc4)</td></tr>
<tr><td> <em>Generated: </em> 11/12/2023 9:15:02 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone-2/grade/shc4" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T01.24.08image.png.webp?alt=media&token=1c00d7fe-079d-4847-9ac6-5585c56975ea"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are the payloads given in the milestone2 prep<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T01.25.57image.png.webp?alt=media&token=6ff1e74a-bb9b-4270-8e47-755d70f1d2e8"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are the various methods in server thread that sets up the payload.<br>Since these are from prep 2, I commented what they do and how<br>they function in general.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T01.35.09image.png.webp?alt=media&token=cb7e8084-09b4-44c2-95b1-82fe4df903e4"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are the other payloads I left a comment explaining what they do.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T01.36.06image.png.webp?alt=media&token=8b3d2c77-c869-46a9-bb84-27a2f4a9b482"/></td></tr>
<tr><td> <em>Caption:</em> <p>The process payload handles all the payloads that were being assigned before. So<br>it basically takes those payloads and goes to the proper case and handles<br>those data for the user.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T01.53.50image.png.webp?alt=media&token=6f550d13-53fd-4330-9580-22cda29c766b"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are some of the payloads being used in the terminal when a<br>user joins a room, sends a message, etc.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T02.01.39image.png.webp?alt=media&token=9fc866e7-7ca5-4033-afc3-9604f81d2fa3"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are the variables that are going to be used in the process<br>commend. The roll and flip in the switch statement of process commend.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T02.03.51image.png.webp?alt=media&token=80be9b9f-c6c6-435e-92f3-4b44605bcba1"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the flip code in the process commend method in room<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-12T02.22.05image.png.webp?alt=media&token=ce0dd5b2-9b93-44e2-aec4-964f1c533cb8"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the code of my roll inside of the process commend in<br>room <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <div>flip function:</div>When the user types in /flip, the code will run a random<br>between 0-1 and so if it is 0 it would be heads and<br>if it is 1 than it would be tails. So in action the<br>server will print out a statement saying which user did the action and<br>show their results of either heads or tails.<div><br></div><div>roll function:</div><div>roll has to work with<br>an if condition that checks if there is a d so it can<br>differentiate between normal roll and 2d6 type of roll. So if there is<br>a d in there are two variables that has splits. One split will<br>have the number of dices that are mentioned in the roll commend and<br>the other will have how many sides each dice has. Than a for<br>loop will run and it based on how many dices there are and<br>there is a random number chosen from how many sides there are. This<br>than gets added to a total variable and than a statement is sent<br>by the server. The statement from the server says who did it and<br>what kind of #d# they did and show their results.</div><div><br>If this condition does<br>not happen with the letter d, it does the other roll. Which basically<br>does a random with how many sides that was mentioned so /roll 10<br>would be a roll from 1 - 10. So once that roll happens<br>a statement is sent by the server and it will say a roll<br>is done from 1 to the mentioned number and print the results. The<br>random is a math.random which is multiplied by the mentioned number added by<br>1 and this is how this roll works.</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T00.31.33image.png.webp?alt=media&token=57ab2cb4-0754-4c56-95e3-b18603d3210c"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is showing how the methods are being called in the send message<br>method of room<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T00.45.10image.png.webp?alt=media&token=84772c63-55e4-4439-b224-788c5d005640"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how bold is being process and to use it the user<br>must type with * symbol<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T00.47.52image.png.webp?alt=media&token=ced9b6af-8bb3-4c80-83b3-164a228dbbfc"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how italics is being processed and to use it, the user<br>must type with - symbol<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T00.51.39image.png.webp?alt=media&token=cbc39602-1061-440b-a658-1f5406c6e9fb"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how underline is being processed and to use it the user<br>must use the _ symbol<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T00.57.27image.png.webp?alt=media&token=95fcac1b-f2f3-438f-86ec-ac9a0e6d026d"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how the color red is being processed and to use it,<br>the user has to use the &amp; symbol<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T00.58.33image.png.webp?alt=media&token=d25434c0-b9cb-4557-9235-c4be96403036"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how the color green is being processed and to use it,<br>the user has to use the % symbol<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T01.01.38image.png.webp?alt=media&token=b33319b6-f72e-4e60-921b-7fff2442e6b8"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how the color blue is being processed and the user must<br>type # symbol to use it<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T01.03.37image.png.webp?alt=media&token=de1e3668-ada0-4a3b-8db4-c234ce041ff0"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how bold is being displayed in the terminal<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T01.07.01image.png.webp?alt=media&token=03c0e8ef-0745-480d-a75e-77eea0ce5336"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how italics is being displayed in the terminal<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T01.08.53image.png.webp?alt=media&token=8e60347d-ae53-4556-904d-38fb83cb0087"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how underline is being displayed in the terminal <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T01.10.22image.png.webp?alt=media&token=0f5dc5af-40b5-46c3-8255-4fabfcc3f7af"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how color is being displayed in the terminal<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-13T01.25.37image.png.webp?alt=media&token=1c8ed4a4-a75a-4f09-b2dc-b7478d655137"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is mix of all options that is being displayed<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>It depends on which symbol is being used. There are different methods created<br>but with the same code and they check if they contain certain symbols.<br>So taking bold for example it uses * to turn the text bold.<br>So it checks if the message contains it. If it does an array<br>called message2 which basically has all characters split up because message does a<br>split for every character. Than the message is set to be a empty<br>string. There is a for loop that iterates through message2. There is a<br>count variable that is being used to track and pair the html bold<br>tags. There is a check variable to see how many times * appears.<br>Lastly, there is trackIndex variable to see where was the last index for<br>the *. So count goes up if it detects a *, so does<br>check. There is if condition that see if the count goes up by<br>1 which means it would place the bold tag at that index and<br>it also trackIndex will remember that spot. than the loop goes again and<br>brings the count and check up. The next if condition that sees if<br>count equals 2 and it will place the end tag at that index<br>and reset count to 0 but not check. Check continuously goes up by<br>1. After the loop ends there is an if condition that will see<br>if the check variable is odd which means a * was not paired.<br>If its not paired than the last trackIndex variable comes in use. Which<br>places back the * where it came from instead of converting it to<br>a tag. Than there is a for each loop that will go through<br>message2 and adds all the characters and spaces back into message. Than it<br>returns the message. This code is repeated for all other functions which means<br>italics, underline, and all colors. So those are separated in their own methods<br>and takes in different symbols and sets up the different tags. So for<br>bold the user would need to use *, for italics the user would<br>need to use -, for underline the user needs to use _, for<br>color red the user needs to use &amp;, for color green the user<br>needs to use %, and for color blue the user needs to use<br>#. These methods return a string and are being called in sendMessage method.<br>If none of the symbol if conditions are met than it will just<br>return the message as it is.<div><br></div><div>Side note: These all contain an if condition<br>in the for loop which helps the user keep the symbols by using<br>backslash right next to it. For example when a user types *fruit*, it<br>would give an output of <em>fruit</em>. So in coding terms it detects where<br>the backlash occurs, than that index is set to an empty string, does<br>an i++, and continue. Since continue goes to the next iteration it does<br>that i++ again. So that basically skips the symbol completely if backslash is<br>right next to it.&nbsp; &nbsp; &nbsp;<hr></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/sajidchowdhury1/shc4-it114-005/pull/7">https://github.com/sajidchowdhury1/shc4-it114-005/pull/7</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone-2/grade/shc4" target="_blank">Grading</a></td></tr></table>