package lrosenberg.flashcards;


public class Card {
    private String front, back;
    private int ntime, ptime;

    public String getFront() {
        return front;
    }

    public void setFront(String newFront) {
        front = newFront;
    }

    public String getBack(){
        return back;
    }

    public void setBack(String newBack) {
        back = newBack;
    }

    public int getNtime() {
        return ntime;
    }

    public void setNtime(int newNtime) {
        ntime = newNtime;
    }

    public int getPtime() {
        return ptime;
    }

    public void setPtime(int newPtime) {
        ptime = newPtime;
    }

    public boolean isDue() {
        return ntime <= System.currentTimeMillis()/1000L;
    }
}