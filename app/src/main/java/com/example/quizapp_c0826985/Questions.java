package com.example.quizapp_c0826985;

public class Questions {
    private String question;
    private String[] opts;
    private int ansInd;

    public Questions(String question, String[] opts, int ansInd) {
        this.question = question;
        this.opts = opts;
        this.ansInd = ansInd;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOpts() {
        return opts;
    }

    public void setOpts(String[] opts) {
        this.opts = opts;
    }

    public int getAnsInd() {
        return ansInd;
    }

    public void setAnsInd(int ansInd) {
        this.ansInd = ansInd;
    }

        public boolean isRight(int indexSelected){
        return ansInd == indexSelected;
        }



}
