<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Sajid Chowdhury (shc4)</td></tr>
<tr><td> <em>Generated: </em> 12/9/2023 6:52:20 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone4/grade/shc4" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-06T23.54.17image.png.webp?alt=media&token=ffbbfe00-737a-48ff-bb74-abd9f7d00a26"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the export button on menus that is going to be used<br>to get the history of the chat<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-06T23.57.18image.png.webp?alt=media&token=0acf59bc-f4a8-4d3e-9d5a-da3e38e4199e"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the variety of chat with different formats<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-06T23.59.09image.png.webp?alt=media&token=9a0194c8-7950-4735-8ea9-29b457e95d4c"/></td></tr>
<tr><td> <em>Caption:</em> <p>The html file that was created after the export<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-06T23.59.59image.png.webp?alt=media&token=71854c73-8f2b-46bc-b25e-06a687b7645b"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the file after being opened<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>This was implemented as a menu button which need a iCardControl method. In<br>there a method was created called export. After that an override method needs<br>to be made but first I would need the chat panel content. In<br>chatPanel I created a method called clientHistory which starts a Component array of<br>chatArea (holds the content of the chat). Then I did a try catch<br>that starts a FileWriter. This File that is created is called chathistory with<br>the time of the computer and it is also an html file. There<br>is a for each loop that iterates through the components array and writes<br>it to the file. This method will be accessed from chatPanel in clientUI.<br>So the method export in clientUI will have chatPanel.clientHistory(); and this export method<br>is called in menu when the button is clicked.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.00.18image.png.webp?alt=media&token=d9dec90c-11a3-4db9-adca-8a5149d7ad25"/></td></tr>
<tr><td> <em>Caption:</em> <p>Mute list is stored as a txt file<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.01.20image.png.webp?alt=media&token=55116815-1c47-487d-883e-ac458d9e6bc6"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the method that starts a filewriter to put names when mute<br>and unmute<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.03.39image.png.webp?alt=media&token=8295fdbf-56ee-47e9-8fcc-bd3e39b138b6"/></td></tr>
<tr><td> <em>Caption:</em> <p>It is called when process payload does mute or unmute in server thread<br>so when a client does a /mute or unmute. This rewrites the file<br>every time with the mute list in server thread.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.09.01image.png.webp?alt=media&token=8f08d23c-69e9-4ab7-8547-ea679808fdf8"/></td></tr>
<tr><td> <em>Caption:</em> <p>Open the file of the same exact name. It will open if the<br>file exist and it goes through the lines and adds everyone back to<br>the mutedList.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.23.03image.png.webp?alt=media&token=1ca5ed32-da4d-44f7-a80b-4216843c9d06"/></td></tr>
<tr><td> <em>Caption:</em> <p>Method is called when the client connects with their name and it persists<br>through different sessions.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>So when client does /mute and /unmute from client side, it send a<br>payload mute and add someone to the mute list. It than calls muteFile()<br>which will do a FileWriter. This will create a file with the clients<br>name and write the names. When it calls again it will overwrite the<br>old file and rewrite with new or removed names. Once a client leaves<br>and connects back in with the same name it will do the method<br>openSavedMuteFile() which is done under the process payload CONNECT. This will run a<br>for loop that everyone back into the mute list. So those names would<br>not be able to send messages through out any sessions.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.36.36image.png.webp?alt=media&token=35222bc9-a1e6-4d43-b545-e939c043739f"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how the message looks for the other client when they get<br>muted<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.40.26image.png.webp?alt=media&token=84b2228c-a4c9-48d2-a255-9e371321b4ef"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is how the message looks for the other client when they get<br>unmuted<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.44.42image.png.webp?alt=media&token=69c830b0-49b4-47e2-b3c9-5858b489a47b"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are two methods in room that looks for names from the parameter<br>given and also takes in who is the sender. This is used in<br>server thread to send the message when mute and unmute payload process happens.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T01.46.42image.png.webp?alt=media&token=3c2295b1-3177-4674-8025-c7845823cb27"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is in server thread and it shows how muteMessage happens under MUTE<br>and how unmuteMessage happens under UNMUTE.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>Two methods are created in rooms that are protected so they can be<br>used in server thread. The methods are similarly coded but are meant for<br>different purposes, one is meant to send a mute message to the other<br>person while the other method is made to send an unmuted a message.<br>So explaining how mutedMessage works also explains how unmutedMessage works. mutedMessage takes two<br>parameters which is the serverThread of the client that is doing the muting<br>and the String name of the person being muted. A for each loop<br>is made to iterate through clients which is a list of serverThreads in<br>the room. An if condition is made to check the names of the<br>clients compared to the string name and if they match than it will<br>target that serverThread to send the message. The message will be coming from<br>the server and it is going to say the name of the person<br>who muted the targeted client. The same logic is applied for unmutedMessage but<br>the message will say that the person who muted them has unmuted them.<br>These methods are called under payload process respectively so muteMessage is called under<br>the MUTE case as currentRoom.muteMessage(this, p.getClientName()); and this is how the name is<br>used from serverThread. For UNMUTE case the unmuteMessage is called similarly.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T15.46.01image.png.webp?alt=media&token=1c0e8e4a-b0e6-4d8b-ab12-be7256640029"/></td></tr>
<tr><td> <em>Caption:</em> <p>In the clients user list the names are grayed out when someone is<br>muted. They are all different for each client since they muted different clients<br>each.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T15.48.42image.png.webp?alt=media&token=33339313-ff4f-402a-b8fc-177781a55ac7"/></td></tr>
<tr><td> <em>Caption:</em> <p>MUTE_LIST is a new payload and this is used to send a string<br>message of muteList from serverThread to the client.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T15.50.09image.png.webp?alt=media&token=f92bd222-2850-466a-9120-41317784d87b"/></td></tr>
<tr><td> <em>Caption:</em> <p>Method is serverThread that will make the muteList into a string and send<br>it as a message to clients.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T15.51.25image.png.webp?alt=media&token=25ad8035-2a21-47dc-9927-0f553c071c41"/></td></tr>
<tr><td> <em>Caption:</em> <p>It is called under the mute and unmute cases and happens right after<br>someone gets added to a list or removed.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T15.57.51image.png.webp?alt=media&token=eecaf31f-3ddd-4c28-99bf-a8f9a292c401"/></td></tr>
<tr><td> <em>Caption:</em> <p>It is also called under CONNECT, so if mute persists happens with names<br>in the file. They first are added back into the list and that<br>sendMuteList will send the muteList to clients. (weird bug for some reason exceptions<br>are thrown but making the thread sleep helped resolve the issue)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.01.55image.png.webp?alt=media&token=955148f4-f7a7-4b4d-a648-6a2d58818bf2"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the MUTE_LIST payload case in clients and this takes the message,<br>splits it into a string array and adds the name to the muteList<br>in clients.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.04.00image.png.webp?alt=media&token=a5a1cb52-a7d5-4e53-8f6e-cf7faceac5c1"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the method in clients that will handle sending data to UserListPanel<br>to handle graying and un-graying for an user that is muted or unmuted.<br>It only takes a string parameter which takes in string &quot;mute&quot; or &quot;unmute&quot;<br>for the respective color. This method uses method from client ui, which uses<br>chat panel method that calls a user list panel method that does the<br>graying out. This method also looks through the muted list and goes through<br>a loop to mute those people in the list. Also it sends the<br>id of the user that needs to be grayed out.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.10.36image.png.webp?alt=media&token=8007d467-f6d1-4cf8-9db8-56e5c1d4dbb8"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is where the methods are being handled and with their respective string<br>&quot;mute&quot; or &quot;unmute&quot;<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.12.53image.png.webp?alt=media&token=d489a338-3d2e-4345-86b5-a19f68c4bc73"/></td></tr>
<tr><td> <em>Caption:</em> <p>UserListPanel method that will handle graying and un-graying based on id and their<br>status.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.13.59image.png.webp?alt=media&token=367c2d21-16d1-4122-88df-4eae04f57268"/></td></tr>
<tr><td> <em>Caption:</em> <p>updateStatus is called under this method as well, to gray out people on<br>first boot.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.16.21image.png.webp?alt=media&token=f5a89c84-070c-4490-896e-9ee8ffa60870"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows how A is highlighted after sending a message.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.17.00image.png.webp?alt=media&token=d3c0aba4-6dc8-4119-9e94-e5373cd85eda"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows how B gets highlighted after doing a message and A is<br>back to being its previous color.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.17.33image.png.webp?alt=media&token=03c22b68-c58c-4681-8fe0-996cf1c0afab"/></td></tr>
<tr><td> <em>Caption:</em> <p>C gets highlighted after doing a message and B is back to its<br>previous colors.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.21.26image.png.webp?alt=media&token=d53396ce-8e6c-4e50-a743-59d58af91545"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows how C is muted and the last person to send a<br>message for A was B, so B stayed highlighted while the other clients<br>had C highlighted.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.29.41image.png.webp?alt=media&token=c9e91531-02ef-4f77-a106-af6dcd5f96ad"/></td></tr>
<tr><td> <em>Caption:</em> <p>There is a updateMessageStatus which takes in an id. This method is called<br>from client ui which calls a method from from chatPanel, which calls a<br>method from UserListPanel.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-12-07T16.35.33image.png.webp?alt=media&token=c543ae9d-d17b-4065-89af-2e2d521ee11e"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is what is handling the the highlight inside of UserListPanel. If the<br>id matches, than the color of the user changes else it would be<br>black.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <div>Graying out on mute:&nbsp;</div><div>A new payload was made which was MUTE_LIST (This was<br>created to send). This is needed to send the muteList from server thread<br>to client. So there is a sendMuteList payload method that is going to<br>send the mute list as a string comma list to client. In client<br>payload process there is a MUTE_LIST case that is going to clear the<br>list every time inside client when this payload is sent (so the mute<br>list in client does not the data after unmuting). The message is split<br>on comas and there is a for each loop that is adding the<br>contents into the muteList in clients. Back to server thread quickly, sendMuteList() method<br>happens under MUTE, UNMUTE, and CONNECT cases of payload process. For cases MUTE<br>and UNMUTE, right after names are added or removed, this method is called<br>to send an updated version of the list to client. For under CONNECT,<br>the mute list data is sent after the mute persist file is opened.<br>To make the graying out work, modification in user list panel needs to<br>be made, so an IClientEvents method was made for client UI to call<br>in client side, this method needs a String of mute status and the<br>id of the client that needs to be grayed out. In user list<br>panel there is a method called updateMuteStatus which takes String mute status and<br>long id.&nbsp; An array of components of user list panel is made and<br>a for each loop that is going through the contents of it. Every<br>component of the array has a name set to them and this is<br>the id of the client. Mute status is used to check as a<br>check between the two if condition, so "mute" would do i.setForeground(Color.GRAY) and "unmute"<br>would do Color.BLACK. This method is than called in chat panel with another<br>method that takes the same parameters, than this chat panel method is called<br>in client ui. This events method is called in client through another method<br>and takes a parameter of string mute status (for "mute" and "unmute"). In<br>this method it loops through the contents of the hash tables of User<br>objects (connected clients). The if condition checks if its "mute" and if the<br>user in the table has a name in the mute list. if it<br>does it calls the the events method which takes the mute status and<br>id parameter which will end up doing the the user list method which<br>would change the color. If its "unmute" and and the name is not<br>contained in the mute list, than it will do the events method which<br>would do the user list panel method to make the name back to<br>gray. The client method is called updateStatus and its called under MUTE and<br>UNMUTE case of the client payload process. Under mute it is called with<br>"mute" and under unmute its called with "unmute". This method is also called<br>in&nbsp;listenForServerPayload under payload process is called. This is to gray out people from<br>the mute persist list.</div><div><br></div><div>Name highlight for last person to send message:</div><div>This is similar<br>to muted people getting grayed out. So to start off with, there is<br>a method in user list panel that takes in a long id.&nbsp; This<br>method check through a loops of components and checks if the id matches.<br>If the id matches than the color will be set to green and<br>else it would be set to black. This method is called in chat<br>panel and in client ui. this client ui method is made as an<br>iclientsevent. Afterwards a this events method is called under MESSAGE case of the<br>client payload process. It takes the parameter of long id so it is<br>set up as events.updateMessageStatus(p.getClientId());. This will do the method in user list panel<br>and set the color to the last person who sent a message.</div><div><br></div><div>Pull Request<br>Link:&nbsp;<a href="https://github.com/sajidchowdhury1/shc4-it114-005/pull/9">https://github.com/sajidchowdhury1/shc4-it114-005/pull/9</a></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone4/grade/shc4" target="_blank">Grading</a></td></tr></table>