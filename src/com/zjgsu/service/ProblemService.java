package com.zjgsu.service;

import java.util.List;
import java.util.Vector;

import model.Problem;
import model.Submitstate;

public interface ProblemService {
	public List<Submitstate> showState();
	public List<Problem> showProblem();
	public void saveState(Submitstate submitstate);
	public String findUsername(int cid);
	public Problem getProblemById(String id);
}
