package io.github.himcs.model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("question")
	private Question question;

	public Question getQuestion(){
		return question;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"question = '" + question + '\'' + 
			"}";
		}
}