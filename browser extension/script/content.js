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
	<a id="bugReportButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Your Reputation">
		<span class="pmd-floating-hidden">Your Reputation</span>
		<i class="fa fa-star-o" aria-hidden="true"></i>
	</a>
	<a id="bugReportButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Report Bug on this page">
		<span class="pmd-floating-hidden">Report Bug on this page</span>
		<i class="fa fa-bug" aria-hidden="true"></i>
	</a> 
	<a id="chatbotButton" href="javascript:void(0);" class="pmd-floating-action-btn btn btn-sm pmd-btn-fab pmd-btn-raised pmd-ripple-effect btn-default" data-title="Chatbot: Ask about Konnex"> 
		<span class="pmd-floating-hidden">Chatbot: Ask about Konnex</span>
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
<div id="askSomethingBox" class="card text-center box">
	<div class="card-header">
		Ask Something
		<button type="button" class="btn btn-sm btn-danger boxClose">
			<i class="fa fa-times circle" aria-hidden="true"></i>
		</button>
		
	</div>
	<div class="card-body">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="basic-addon1">
				<i class="fa fa-search" aria-hidden="true"></i>
			</span>
		</div>
		<input type="text" class="form-control" placeholder="type your query..." aria-label="query" aria-describedby="basic-addon1">
	</div>
		<p class="card-text">1. FAQ1</p>
		<p class="card-text">2. FAQ2</p>
		<p class="card-text">3. FAQ3</p>
	</div>
	<div class="card-footer text-muted">
		Can't find your question here? <a href="#" class="btn btn-primary">Write your Query</a>
	</div>
</div>

`
var askSomethingBox = document.createElement("div");
askSomethingBox.innerHTML = askSomethingBoxHtml;

document.body.appendChild(floatingButtons);
document.body.appendChild(askSomethingBox);


/*======== Injecting JavaScript ========*/
var listOfBoxIds = ["askSomethingBox"]
function closeAllBoxes(){
	for (id of listOfBoxIds){
		document.getElementById(id).style.display = "none";
	}
}
closeAllBoxes();

boxCloseButtons = document.getElementsByClassName("boxClose");
boxCloseButtons[0].addEventListener('click', closeAllBoxes());
for (button of boxCloseButtons){
	button.addEventListener('click', function(){
		closeAllBoxes();
		}
	);	
}

askSomethingButton = document.getElementById("askSomethingButton");
askSomethingButton.addEventListener('click', function(){
	closeAllBoxes();
	document.getElementById("askSomethingBox").style.display = "block";
	}
);
