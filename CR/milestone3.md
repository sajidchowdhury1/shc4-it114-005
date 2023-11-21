<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Sajid Chowdhury (shc4)</td></tr>
<tr><td> <em>Generated: </em> 11/21/2023 3:48:44 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone3/grade/shc4" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-20T20.25.12image.png.webp?alt=media&token=f3aa4822-45d9-40eb-be7b-42ab4b0a598b"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is showing the host and port of the UI screen<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-20T20.26.16image.png.webp?alt=media&token=ff5ed1fe-6e3f-4d12-9835-ba0d5c2f5096"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is showing the username of the UI screen<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <ul><br><li>The UI interface takes in info such as host IP, port, and<br>user name through those textboxes (IP and port have default text which can<br>be used)<div><div>- Those data are handled in connect() of clientUI</div><div>- In that method,<br>those data are assigned to variables that is going to be used connect<br>the clients</div><div>- All clients have a singleton that basically gives them the ability<br>to have instances different from one another, which clients are separated and take<br>data different from one another</div><div>- So when Client.INSTANCE.connect(...) is called with all the<br>parameters, it connects that one instance of client</div><div>- Other clients have to connect<br>with their on inputs</div></div><br></li><br></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T01.20.28image.png.webp?alt=media&token=5accb656-4bb3-4338-96e1-270ee97f412d"/></td></tr>
<tr><td> <em>Caption:</em> <p>This shows a list of users, a chat history of messages, and create<br>message area with send button<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T01.29.12image.png.webp?alt=media&token=7da69487-0200-4cf2-bbf6-0af1e7006a6e"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the code in Chat Panel UI that is going to see<br>if the enter key is pressed to do the send button action<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T01.36.49image.png.webp?alt=media&token=7cec59ba-7fbb-4fdd-95b7-3c9fc066fd76"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is showing how one client did their /flip. It shows up as<br>a server message and says which user did the commend and their results<br>from the output. It also has html tags to make it look different<br>from normal messages.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T01.39.26image.png.webp?alt=media&token=ad9a0db2-7ef0-445e-892a-d86b05890162"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screen shot shows the two different roll types and who did these<br>commends. It also appears as a server message with html format to make<br>it look different from normal text.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T02.20.03image.png.webp?alt=media&token=b9006b9c-3e18-40ac-aa5f-39091e7e8b14"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the /flip function that is found on the server side which<br>is being handled in process commends of room. This has comments on how<br>the format logic works and how the code works.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T02.42.24image.png.webp?alt=media&token=eecdd0a2-5e30-4e54-9cc6-7d543922993e"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the /roll function that is found server side which is being<br>handled in process commends of room. This has comments on how the messages<br>are formatted and the logic of how the code works step by step.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <p>/flip method:<div>After typing /flip in the ui, the room processCommend will be handling<br>that logic. So essentially, under the case statement of FLIP, it has the<br>code that will generate a message that is either heads to tells. There<br>is a coin variable that will generate a random between 0 or 1.<br>If it is 0, it does a message of who did the flip<br>and the result will be heads. If it is 1, it does a<br>message of who did the flip and the result will be tails.</div><div><br></div><div>/roll #d#<br>method:</div><div>After typing /roll #d#, this commend will be processed in rooms. There is<br>a variable that will take number of dices which is the first number<br>before d. Than there is a variable that will get the number of<br>sides which is the number after d. There is a for loop that<br>will iterate from the number of dice. Inside the for loop, there is<br>a variable made to handle the rolls which is a random with the<br>number of sides added by 1 so it can do start from 1<br>and not with 0. As it iterates and creates those randoms values, it<br>is added on to a total variable. After this is done, it will<br>say who did the roll, with #d# of what they chose, and their<br>results.</div><div><br></div><div>/roll # method:</div><div>The top roll happens when an if condition contains &#39;d&#39;, so<br>the /roll # is an else that happens if the condition is not<br>met. So there is a variable that takes in the number after /roll.<br>There is another variable that handles a random between 1 to the value<br>given. Than a sendMessage happens on who did the roll, there random from<br>1, and their results.</div><div><br></div><div>Formatting:</div><div>The send message is formatted with string format and puts<br>the data in the correct spot. There is also html tags included to<br>make it look different from other text. Mostly formatted with bold and color<br>tags. Lastly, the sendMessage happens with the server sending the message.</div><div><br></div><div>client-&gt;server-&gt;client flow:<br></div><div>- From<br>client: When a client types a message that contains the / commend of<br>flip or roll, it is being sent as a payload MESSAGE to server<br>thread</div><div>- From serverThread: it processes the payload, it sends to the the room<br>the user is in, and the message gets processed by rooms</div><div>- In side<br>of sendMessage of rooms, that method will check if it is a commend,<br>than goes to processCommend</div><div>- The processCommend will handle whatever commend was sent and<br>sometimes do a sendMessage which will go back into serverThread and come back<br>to the room</div><div>- From room in sendMessage method, It does a sendMessage that<br>takes in clientId, that send a payload MESSAGE back to client from serverThread</div><div>-<br>The payload is processed in client which does a method from client UI</div><div>-<br>The UI, it will get show the message to the User/clients interface</div><div>- These<br>messages are sent to all clients of the room unless sendMessage is used<br>as &quot;client.sendMessage(..., &quot;...&quot;) which would target a specific person</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T16.56.55image.png.webp?alt=media&token=1f2021de-df7d-48ba-b73a-60bf64b1deb2"/></td></tr>
<tr><td> <em>Caption:</em> <p>To use bold the sentence is wrapped around * which will be processed<br>by rooms to format the text.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T16.58.49image.png.webp?alt=media&token=c8357e43-6172-4743-ac8a-ace1cf519699"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the result of bold after the message is sent. User A<br>sends this message.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.02.07image.png.webp?alt=media&token=f5931d14-40e3-4afd-9700-8cbb0d79e9af"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is italics that is being used in the sentence when the sentence<br>gets wrapped with -<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.04.50image.png.webp?alt=media&token=921c542e-89b0-4349-a410-3e9e2114ab69"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the sentence being sent in italics format. User B sends this<br>message.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.11.56image.png.webp?alt=media&token=0e230401-7a6d-405f-bb74-66265e53fcbf"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the use of underline which has the sentence wrapped between _<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.13.03image.png.webp?alt=media&token=3b8c219c-7211-4d6d-8d84-a6d257734b23"/></td></tr>
<tr><td> <em>Caption:</em> <p>The sentence was sent using underlines for the whole sentences. This was sent<br>by the user C.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.17.45image.png.webp?alt=media&token=dbde7faf-76a3-4b77-9813-c7c9f9ad6e35"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are the color formatted sentences. To use red the sentence has to<br>be wrapped with &amp;. To use green the sentence has to be wrapped<br>with %. To use blue, the sentence has to be wrapped with #.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.26.33image.png.webp?alt=media&token=af3a4ee6-c71f-4e14-8481-7e4359a006cd"/></td></tr>
<tr><td> <em>Caption:</em> <p>User A sends there message formatted in color red. User B sends there<br>message formatted in color green. User C sends there message formatted in color<br>blue.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.33.23image.png.webp?alt=media&token=cdef3ec7-7309-436e-be06-e4ecd173601c"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the sentence that is being sent to use all symbols to<br>format the sentence. This is going to all the html tags in one<br>sentence.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T17.35.09image.png.webp?alt=media&token=bed7855c-9cdf-4a2d-8b88-ce40480ae644"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the message sent with the combination for formatting. This message was<br>sent by user A.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>In clientUI it has methods that use addText() to put messages on the<br>UI. This addText() method comes from a file called ChatPanel. Inside the it<br>contained a line of code that did plain text. This was &quot;JEditorPane textContainer<br>= new JEditorPane(&quot;text/plain&quot;, text);&quot;. To format the html tag messages, the parameter that<br>has the string &quot;text/plain&quot; has to be changed to &quot;text/html&quot;. This would format<br>every html tag that it sees into its proper form. So when users<br>use the symbols, it first converts where those symbol are into html tags,<br>then the UI handles those messages with the tags and displays the proper<br>format.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T18.30.29image.png.webp?alt=media&token=811e14f6-f7ab-4220-8c7d-bb96d8ba4b94"/></td></tr>
<tr><td> <em>Caption:</em> <p>This show how the message @username has to be formatted to send the<br>message. To work correctly, the user needs to type &quot;@Username:UserId (message)&quot; to send<br>the message properly to the other user.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T18.30.48image.png.webp?alt=media&token=649d85fe-566c-453d-b372-73266b166100"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the private message being sent. The color brown for the text<br>is for the person sending the private message. The color green is for<br>the person who is getting the private message.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T18.35.46image.png.webp?alt=media&token=6ba55ffe-8d27-4f5a-a83e-0e9e782e32b6"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the code inside of sendMessage of rooms. This is what is<br>handling the private messages for the clients. They are targeted by having i.sendMessage,<br>which would send them specifically that message.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>If condition is looking if the sender is not null so serverMessages can<br>work and it is looking for if the message starts with an @.<br>This will than trigger all the code needed to send the message specifically<br>to the other person. The code is wrapped in try catch block because<br>the splits can throw an error if it is not done correctly. To<br>privately send a message the user must type @Username:ID (message) to properly work.<br>This first variable is looking for the username after the &#39;@&#39; and the<br>second variable is looking for the ID after the &#39;:&#39;. There is an<br>if condition checking if someone typed a username correctly or else it would<br>throw an exception and send an error message to do it properly. Sender<br>would get the message for themselves first which is done by doing sender.sendMessage(...,&quot;...&quot;);<br>this is how it targets the sender of the message. Than the code<br>goes through a for each loop of all the clients in the server.<br>An if condition checks if the name and id matches. When it does,<br>it does i.sendMessage(..., &quot;...&quot;); to target that specific user. These messages are formatted<br>in different colors to show to the message to the sender what they<br>sent and to show to the other user that they are being send<br>a private message.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T18.59.30image.png.webp?alt=media&token=a35c1d5a-424b-4256-9d31-cb465ae9f122"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is showing how user A muted user C and only user B<br>can see User C&#39;s message since they did not mute them. User A<br>can only see users B message since they are unmuted.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.01.59image.png.webp?alt=media&token=a965f837-947e-4207-a070-61d2ecf58b3e"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is showing unmute working when A unmute C. C is able to<br>message A and everyone in the room.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.06.48image.png.webp?alt=media&token=fa59b584-a3df-4b47-ae64-efa8d279d2a3"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is show where the isMute method is being used to stop a<br>sender from sending a message to that user. This is for the private<br>message under sendMessage of rooms. So users cannot privately send messages if they<br>are muted.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.08.42image.png.webp?alt=media&token=b20e6545-2b39-46a5-8a0d-6f7c6d547eda"/></td></tr>
<tr><td> <em>Caption:</em> <p>This has isMuted because this is where messages get sent to everyone. This<br>is to prevent those messages in general from coming to the user if<br>the sender is muted.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.10.48image.png.webp?alt=media&token=a846fb66-332c-4e2c-9574-62aa9000a8b1"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the mute list in server thread that is individualized for each<br>client. This add in list of names to mute. This is the mute<br>list that is being interacted with. <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.13.50image.png.webp?alt=media&token=7ed170ed-41f6-4d3a-96c8-06e6de7293ef"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the isMuted method inside of serverThreads that is checking if someone<br>is apart of the list or not for each client.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.15.17image.png.webp?alt=media&token=08abaa36-28a5-4a4b-9283-15c11e593a5d"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is processCommends that will check commends from each client to see who<br>they are muting.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.17.39image.png.webp?alt=media&token=6cf814a8-ae29-4677-a287-984456cb634c"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payload methods inside of clients to handle mute and unmute and these send<br>the payloads to serverThread.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.18.26image.png.webp?alt=media&token=1ff88c56-e934-47ac-9470-6b694f22df59"/></td></tr>
<tr><td> <em>Caption:</em> <p>The two new payloads that will handle mute and unmute<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.19.20image.png.webp?alt=media&token=e55e201f-1fb8-426b-b8fd-7722f0815d3d"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is inside of processPayloads of serverThread, which will add names to the<br>mute list and remove them from the mute list. <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.20.30image.png.webp?alt=media&token=2182d610-3440-4aab-a60c-2f166772e8c0"/></td></tr>
<tr><td> <em>Caption:</em> <p>These are the payload methods that send data back to the client about<br>who is muted and who is not muted.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.22.11image.png.webp?alt=media&token=42f1b451-ccc5-4518-aab7-0984fad2e037"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is in processPayloads of client. This will send a message to the<br>user of who they muted and unmuted once those payloads come back from<br>serverThread.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fshc4%2F2023-11-21T19.28.02image.png.webp?alt=media&token=e6cd6319-b831-401b-b02a-e3a23b956f21"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is the new sendMessage of client that will check if its a<br>comment and skip doing the payload of a message if its a commend.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>There are two new payloads created called MUTE and UNMUTE which are going<br>to be used to add/remove username of users from a serverThread list. There<br>are payload methods created inside of client to send the data of muted<br>and unmuted names to serverThread. There is processCommend that is checking if the<br>user did /mute or /unmute with a name. If they do use those<br>commends, it will send the appropriate payloads to serverThread. The sendMessage method of<br>client has been modified to check if its a commend and this will<br>stop commends from being sent as a message. In processPayloads of serverThread it<br>is going to check which payload is being process. For MUTE payload it<br>will check if the name is apart of the muteList of strings and<br>if they are not in there they will be added into the list.<br>Payload method was made to be sent back to client. If the payload<br>UNMUTE is processed, this would simply remove them from the list and send<br>a payload back to the client. Once these payload comes back to the<br>client, they will be processed in processPayload which will basically send messages to<br>them if they are muted or have been unmuted with their name. In<br>room&#39;s sendMessage it has to be modified with if condition checking if a<br>name for a serverThread client has been muted. This condition has two be<br>done twice for private message and and regular message. for private message it<br>does its usual @ commend and than in the for loop the first<br>condition checks for each serverThread client muteList. So it does i.isMuted(sender...) to see<br>if the sender isMuted for the client, if so it will skip that<br>iteration of the client and prevent that message from being sent. For regular<br>messages, it is inside that while loop that sendMessages to everyone. There is<br>an if condition checking ever clients muteList by using isMuted. It checks if<br>the senders name is muted and does a continue if they are muted.<br>So that message will be skipped from happening.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/sajidchowdhury1/shc4-it114-005/pull/8">https://github.com/sajidchowdhury1/shc4-it114-005/pull/8</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone3/grade/shc4" target="_blank">Grading</a></td></tr></table>