/*======== Injecting CSS ========*/
var style = document.createElement('link');
style.rel = 'stylesheet';
style.type = 'text/css';
style.href = chrome.extension.getURL('style/content.css');
(document.head||document.documentElement).appendChild(style);


/*======== Injecting HTML ========*/
var floatingButtonsHtml = 
`
<!--=============== Floating Action Button ===============-->
<div class="menu pmd-floating-action"  role="navigation">
	<a id="reputationButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Your Reputation">
		<span class="pmd-floating-hidden">Your Reputation</span>
		<i class="fa fa-star-o" aria-hidden="true"></i>
	</a>
	<a id="bugReportButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Report Bug on this page">
		<span class="pmd-floating-hidden">Report Bug on this page</span>
		<i class="fa fa-bug" aria-hidden="true"></i>
	</a> 
	<a id="chatbotButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Chatbot: Ask about Konnex"> 
		<span class="pmd-floating-hidden">Kobot: Ask about Konnex</span>
		<i class="fa fa-commenting-o" aria-hidden="true"></i>
	</a> 
	<a id="askSomethingButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Ask for Something on this page"> 
		<span class="pmd-floating-hidden">Ask for Something on this page</span>
		<i class="fa fa-search" aria-hidden="true"></i>
	</a> 
	<a class="pmd-floating-action-btn btn pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-primary" data-title="Konnex" href="javascript:void(0);">
		<span class="pmd-floating-hidden">Konnex</span>
		<i class="fa fa-users" aria-hidden="true"></i>
	</a> 
</div>

`
var floatingButtons = document.createElement("div");
floatingButtons.innerHTML = floatingButtonsHtml;

var askSomethingBoxHtml = 
`
<!--=============== Ask Something Box ===============-->
<div id="askSomethingBox" class="card text-center my-box">
	<div class="card-header">
		Ask for Something on this WebPage
		<button type="button" class="btn btn-sm btn-danger boxClose">
			<i class="fa fa-times circle" aria-hidden="true"></i>
		</button>
	</div>

	<div class="card-body">
		<h2>FAQs for this Page</h2>
		<div id="populateFaq" class="content-scrollable">
		</div>
	</div>
	<div class="card-footer text-muted">
		Can't find your question here? Write your query here so that someone can answer it...
		<textarea class="form-control" id="questionTextArea" rows="2"></textarea>
		<a href="#" id="askQuestionButton" class="btn btn-primary">Ask Question</a>
	</div>
</div>

`
var askSomethingBox = document.createElement("div");
askSomethingBox.innerHTML = askSomethingBoxHtml;


var answerBoxHtml = 
`
<!--=============== Answer Box ===============-->
<div id="answerBox" class="card text-center my-box">
	<div class="card-header">
		<span id="questionStatement"></span>
		<button id="answerBoxCloseButton" type="button" class="btn btn-sm btn-danger">
			<i class="fa fa-times circle" aria-hidden="true"></i>
		</button>
	</div>

	<div class="card-body">
		<h2>Answers for this question</h2>
		<div id="populateAnswer" class="content-scrollable">
		</div>
	</div>
	<div class="card-footer text-muted">
		You can also answer this question to help others..
		<textarea class="form-control" id="answerTextArea" rows="2"></textarea>
		<a href="#" id="submitAnswerButton" class="btn btn-primary">Submit Answer</a>
	</div>
</div>
`
var answerBox = document.createElement("div");
answerBox.innerHTML = answerBoxHtml;


var bugReportBoxHtml = 
`
<!--=============== Bug Report Box ===============-->
<div id="bugReportBox" class="card text-center my-box">
	<div class="card-header">
		Report Bug on this page
		<button type="button" class="btn btn-sm btn-danger boxClose">
			<i class="fa fa-times circle" aria-hidden="true"></i>
		</button>
	</div>

	<div class="card-body">
		<br>
		Please completely explain the error or bug you have encountered on thid page
		<br><br>
		<textarea class="form-control" id="answerTextArea" rows="6"></textarea>
		<br>
		<br>
		<a href="#" id="submitBugReportButton" class="btn btn-primary">Submit Report</a>
	</div>
</div>
`

var bugReportBox = document.createElement("div");
bugReportBox.innerHTML = bugReportBoxHtml;


var reputationBoxHtml = 
`
<!--=============== Reputation Box ===============-->
<div id="reputationBox" class="card text-center my-box">
	<div class="card-header">
		Your Reputation
		<button type="button" class="btn btn-sm btn-danger boxClose">
			<i class="fa fa-times circle" aria-hidden="true"></i>
		</button>
	</div>

	<div class="card-body">
		<h1>Your Score</h1>
		<h2 id="userScore"></h1>
		<h1>Total Questions Answered</h1>
		<h2 id="userTotalQuestionsAnswered"></h1>
	</div>
</div>
`

var reputationBox = document.createElement("div");
reputationBox.innerHTML = reputationBoxHtml;


var kobotBoxHtml = 
`
<!--=============== Kobot Box ===============-->
<div id="kobotBox" class="card text-center my-box">
	<div class="card-header">
		Chatbot: Ask about Konnex
		<button type="button" class="btn btn-sm btn-danger boxClose">
			<i class="fa fa-times circle" aria-hidden="true"></i>
		</button>
	</div>

	<div class="card-body">
		<iframe id="dialogflowFrame" allow="microphone;" src="https://console.dialogflow.com/api-client/demo/embedded/5c6313a9-a894-4e21-af69-518713e2e0ab"></iframe>
	</div>
</div>
`

var kobotBox = document.createElement("div");
kobotBox.innerHTML = kobotBoxHtml;

document.body.appendChild(floatingButtons);
document.body.appendChild(askSomethingBox);
document.body.appendChild(answerBox);
document.body.appendChild(bugReportBox);
document.body.appendChild(reputationBox);
document.body.appendChild(kobotBox);


/*======== Injecting JavaScript ========*/
var listOfBoxIds = ["askSomethingBox", "bugReportBox", "reputationBox", "kobotBox"]
function closeAllBoxes(){
	for (id of listOfBoxIds){
		document.getElementById(id).style.display = "none";
	}
}
closeAllBoxes();

boxCloseButtons = document.getElementsByClassName("boxClose");
// boxCloseButtons[0].addEventListener('click', closeAllBoxes());
for (button of boxCloseButtons){
	button.addEventListener('click', function(){
		closeAllBoxes();
		}
	);	
}

document.getElementById('answerBox').style.display = "none";
document.getElementById('answerBoxCloseButton').addEventListener('click', function(){
			document.getElementById('answerBox').style.display = "none";
		}
);

document.getElementById('bugReportButton').addEventListener('click', function(){
	document.getElementById('bugReportBox').style.display = "block";
});


/*========= FAQ BOX =============*/
askSomethingButton = document.getElementById("askSomethingButton");
askSomethingButton.addEventListener('click', function(){
	closeAllBoxes();	
	var host = window.location.host;
	console.log("Current HOST: " + host);
	getFaqs(host);
	document.getElementById("askSomethingBox").style.display = "block";
	}
);

function getFaqs(pageUrl){
	var payload = {
		"pageUrl" : pageUrl
	}
	fetch('http://localhost:8080/faq/all', {
	    method: 'post',  
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(payload)
	})
	.then(response => response.json())
	.then(json => {
		console.log(json);
		document.getElementById('populateFaq').innerHTML = "";
		var index = 0;
		for (faq of json){
			index = index + 1;
			var anchor = document.createElement("A");
			var text = document.createTextNode(index + '. ' + faq.question);
			anchor.setAttribute("href", "#");

			anchor.setAttribute("faqId", faq.faqId);
			anchor.setAttribute("question", faq.question);		

			anchor.appendChild(text);
			anchor.addEventListener('click', function(event){
				showAnswers(this);
			}, false);
			var para = document.createElement("p");
			para.appendChild(anchor);
			document.getElementById('populateFaq').appendChild(para);
		}
	})
}

var currentlyOpenedAnswerBoxfaqId = null;
/*========= ANSWER BOX =============*/
function showAnswers(obj){
	faqId = obj.getAttribute("faqId");
	question = obj.getAttribute("question");
	var payload = {
		"faqId" : faqId
	}
	fetch('http://localhost:8080/answer/all', {
	    method: 'post',  
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(payload)
	})
	.then(response => response.json())
	.then(json => {
		console.log(json);
		document.getElementById('questionStatement').innerHTML = question;
		document.getElementById('populateAnswer').innerHTML = "";
		var index = 0;
		for (ans of json){
			index = index + 1;
			var para = document.createElement("p");
			var text = document.createTextNode("Answer " + index + ". " + ans);
			para.appendChild(text);
			document.getElementById('populateAnswer').appendChild(para);
			document.getElementById('populateAnswer').appendChild(document.createElement("hr"));
		}
	})
	currentlyOpenedAnswerBoxfaqId = faqId;
	document.getElementById("answerBox").style.display = "block";

}

/*========= ASK QUESTION =============*/
document.getElementById('askQuestionButton').addEventListener('click', function(){
	var question = document.getElementById('questionTextArea').value;
	if(question.length!=0){
		var host = window.location.host;
		console.log("Current HOST: " + host);

		var payload = {
			"pageUrl" : host,
			"question" : question
		}
		fetch('http://localhost:8080/faq/create', {
		    method: 'post',  
		    headers: {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json',
		      'token': '300a8498-124e-4081-9a3a-96e2ce5f961c'
		    },
		    body: JSON.stringify(payload)
		})
		.then(response => response.json())
		.then(json => {
			console.log(json);
		})
		
		getFaqs(host);
		document.getElementById("questionTextArea").value = "";
		window.alert("Your Query has been raised!");
		closeAllBoxes();
	}
	}
);


/*========= SUBMIT ANSWER =============*/
document.getElementById('submitAnswerButton').addEventListener('click', function(){
	var answer = document.getElementById('answerTextArea').value;
	if(answer.length!=0){
		console.log("currentlyOpenedAnswerBoxfaqId: " + currentlyOpenedAnswerBoxfaqId)
		var payload = {
			"faqId" : currentlyOpenedAnswerBoxfaqId,
			"answer" : answer
		}
		fetch('http://localhost:8080/answer/create', {
		    method: 'post',  
		    headers: {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json',
		      'token': '300a8498-124e-4081-9a3a-96e2ce5f961c'
		    },
		    body: JSON.stringify(payload)
		})
		.then(response => response.json())
		.then(json => {
			console.log(json);
		})
		
		document.getElementById("answerTextArea").value = "";
		window.alert("Your answer has been recorded!");
		document.getElementById("answerBox").style.display = "none";
	}
	}
);

/*========= SHOW REPUTATION =============*/
document.getElementById('reputationButton').addEventListener('click', function(){
	fetch('http://localhost:8080/', {
	    method: 'post',  
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json',
	      'token': '300a8498-124e-4081-9a3a-96e2ce5f961c'
	    }
	})
	.then(response => response.json())
	.then(json => {
		console.log(json);
		document.getElementById("userScore").innerHTML = json.totalScore;
		document.getElementById("userTotalQuestionsAnswered").innerHTML = json.noOfQuestionsAnswered;
	})	
		document.getElementById("reputationBox").style.display = "block";
	}
);


/*========= SHOW KOBOT =============*/
document.getElementById('chatbotButton').addEventListener('click', function(){	
		document.getElementById("kobotBox").style.display = "block";
	}
);