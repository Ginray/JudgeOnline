package model;

import javax.persistence.*;

/**
 * Created by Ginray on 2017/2/12.
 */
@Entity
@Table(name = "solution", schema = "zjgsu_oj")
public class SolutionEntity {
    private int problemId;
    private String input;
    private String output;

    @Id
    @Column(name = "problem_id")
    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "input")
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "output")
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolutionEntity that = (SolutionEntity) o;

        if (problemId != that.problemId) return false;
        if (input != null ? !input.equals(that.input) : that.input != null) return false;
        if (output != null ? !output.equals(that.output) : that.output != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problemId;
        result = 31 * result + (input != null ? input.hashCode() : 0);
        result = 31 * result + (output != null ? output.hashCode() : 0);
        return result;
    }
}
