package com.one.abc.customer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errors {
private List<ErrorResponseVO> errors;

public List<ErrorResponseVO> getErrors() {
	return errors;
}

public void setErrors(List<ErrorResponseVO> errors) {
	this.errors = errors;
}


}
