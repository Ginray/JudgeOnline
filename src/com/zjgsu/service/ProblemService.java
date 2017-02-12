package com.zjgsu.service;

import java.util.List;
import java.util.Vector;

import model.Problem;
import model.Submitstate;
import model.UserInfo;

public interface ProblemService {
	List<Submitstate> showState();
	List<Problem> showProblem();
	void saveState(Submitstate submitstate);
	String findUsername(int cid);
	Problem getProblemById(String id);
	List<Problem> searchProblem(String keyword);
	List<Submitstate>searchState(String keyword);
	String returnInput(String problemId);
	String returnOutput(String problemId);
}
