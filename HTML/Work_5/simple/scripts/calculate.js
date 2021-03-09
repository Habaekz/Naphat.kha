function doIt()
{
    // Variables for HTML element DOM references.
    var num1Ref, num2Ref, num3Ref, num4Ref, num5Ref, num6Ref, answerRef, eodRef, answer_subtractionRef; 
    
    // Variables declarations.
    var num1, num2, num3, num4, num5, num6, answer, eod, answer_subtraction; 
    
    // Get references to DOM elements.
    num1Ref = document.getElementById("num1");
    num2Ref = document.getElementById("num2");
    num3Ref = document.getElementById("num3");
    answerRef = document.getElementById("answer");
    eodRef = document.getElementById("eod");
    answer_subtractionRef = document.getElementById("answer_subtraction");

    // Convert strings to numbers, e.g., "21" to 21.
    num1 = Number(num1Ref.value);
    num2 = Number(num2Ref.value);
    num3 = Number(num3Ref.value);
    
    // Perform addition operation then assignment operation
    answer = num1 + num2 + num3; 
    answer_subtraction = num1 - num2 - num3;

    // Update "answer" label DOM to show result using "innerText" property. innerText is a property of label tag.
    answerRef.innerText = answer;
    

    if(answer%2==0)
    {
        eodRef.innerText = "(even)";    
        eodRef.className = "even"; 
    }
    else
    {
        eodRef.innerText = "(odd)";  
        eodRef.className = "odd"; 
    }
    
    if (answer >= 0)
    {
        // Value of answer is positive.
        // Set the class of the answer label to "positive".
        answerRef.className = "positive";
    }
    else
    {
        // Value of answer is not positive, i.e., negative.
        // Set the class of the answer label to "negative".
        answerRef.className = "negative";
    }

}
 
function doIt_two()
{
    // Variables for HTML element DOM references.
    var num1Ref, num2Ref, num3Ref, num4Ref, num5Ref, num6Ref, answerRef, eodRef, eod_twoRef, answer_subtractionRef; 
    
    // Variables declarations.
    var num1, num2, num3, num4, num5, num6, answer, eod, eod_two, answer_subtraction; 
    
    // Get references to DOM elements.
    num1Ref = document.getElementById("num1");
    num2Ref = document.getElementById("num2");
    num3Ref = document.getElementById("num3");
    num4Ref = document.getElementById("num4");
    num5Ref = document.getElementById("num5");
    num6Ref = document.getElementById("num6");
    answerRef = document.getElementById("answer");
    eodRef = document.getElementById("eod");
    eod_twoRef = document.getElementById("eod_two");
    answer_subtractionRef = document.getElementById("answer_subtraction");

    // Convert strings to numbers, e.g., "21" to 21.
    num1 = Number(num1Ref.value);
    num2 = Number(num2Ref.value);
    num3 = Number(num3Ref.value);
    num4 = Number(num4Ref.value);
    num5 = Number(num5Ref.value);
    num6 = Number(num6Ref.value);
    
    // Perform addition operation then assignment operation
    answer = num1 + num2 + num3; 
    answer_subtraction = num4 - num5 - num6;

    // Update "answer" label DOM to show result using "innerText" property. innerText is a property of label tag.
    
    answer_subtractionRef.innerText = answer_subtraction;

    if(answer_subtraction%2==0)
    {
        eod_twoRef.innerText = "(even)";
        eod_twoRef.className = "even";  
    }
    else
    {
        eod_twoRef.innerText = "(odd)"; 
        eod_twoRef.className = "odd";  
    }

    if (answer_subtraction >= 0)
    {
        // Value of answer is positive.
        // Set the class of the answer label to "positive".
        answer_subtractionRef.className = "positive";
    }
    else
    {
        // Value of answer is not positive, i.e., negative.
        // Set the class of the answer label to "negative".
        answer_subtractionRef.className = "negative";
    }
}
    
