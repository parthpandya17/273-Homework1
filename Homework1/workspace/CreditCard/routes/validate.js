"use strict";
var ejs = require("ejs");

function CreditCard(cardNumber,cvvNumber,validTillMonth, validTillYear)
{
	this.cardNumber = cardNumber;
	this.cvvNumber =cvvNumber;
	this.validTillMonth = validTillMonth;
	this.validTillYear = validTillYear;
}

function regexTest(regex, value)
{
	if (regex.test(value))
	{
		return true;
	}
	else
	{
		return false;
	}
}




function doValidations(objCreditCard)
{
	var i = 0;
	while(1)
		{
		i++;
		}
	var regexMonth = /^(0?[1-9]|1[0-2])$/;
	var regexYear = /^[0-9]{4}$/;
	var regexCard = /^(?=[0-9]*$)(?:.{11}|.{14}|.{15}|.{16})$/;
	var regexCvv = /^[0-9]{3,4}$/;
	if(regexTest(regexMonth, objCreditCard.validTillMonth) && 
			regexTest(regexYear, objCreditCard.validTillYear) && 
			regexTest(regexCard, objCreditCard.cardNumber) && 
			regexTest(regexCvv, objCreditCard.cvvNumber))
	{
		
		var currentDate = new Date();
		var bValidate = false;
		if(objCreditCard.validTillYear < currentDate.getFullYear())
		{
			
			return false;
		}
		else if (objCreditCard.validTillYear == currentDate.getFullYear() && 
				objCreditCard.validTillMonth < currentDate.getMonth())
		{
			return false;
		}
		else
		{
			
			if(objCreditCard.cardNumber.length != 15 && objCreditCard.cvvNumber.length == 3)
			{
				console.log("I");
				return true;
			}
			else if(objCreditCard.cardNumber.length == 15 && objCreditCard.cvvNumber.length == 4)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	else
	{	
		
		return false;
	}
}

function validate(req, res)
{
	console.log("got the request");
	
	var objCreditCard = new CreditCard(req.param("cardNumber"),req.param("cvvNumber"),req.param("validTillMonth"), req.param("validTillYear"));

	if (doValidations(objCreditCard))
	{
		console.log("J");
		ejs.renderFile('./views/index.ejs', {
		    title : 'Express',
		    cardNumber : req.param("cardNumber"),
		    cvvNumber : req.param("cvvNumber"),
		    validTillMonth : '',
		    validTillYear : '',
		    validationResult : 'Validation Result: Success'
		}, function(err, result)
		{
			
			if (!err)
			{
				res.end(result);
			}
			else
			{
				res.end("An error occurred.");
			}
		});
	}
	else
	{
		console.log("K");
		ejs.renderFile('./views/index.ejs', {
		    title : 'Express',
		    cardNumber : req.param("cardNumber"),
		    cvvNumber : req.param("cvvNumber"),
		    validTillMonth : 'req.param("validTillMonth")',
		    validTillYear : 'req.param("validTillYear")',
		    validationResult : 'Validation Result: Failed'
		}, function(err, result)
		{
			if (!err)
			{
				res.end(result);
			}
			else
			{
				res.end("An error occurred.");
			}
		});
	}
	console.log("end");
}

exports.validate = validate;