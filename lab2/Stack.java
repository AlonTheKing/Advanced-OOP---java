package com.lab2;


class Stack {
    private int[] data;
    private int top1;

	public Stack() {
        this.top1 = 0;
        this.data = new int[1];
    }

    public void push(int x){
	    if (this.top1<1){
	        this.data[this.top1] = x;
	        this.top1 += 1;
        }
	    else{
	        // backup the stack's data in a temp array
	        int[] temp = new int[this.top1];
	        for(int i = 0; i<this.top1;++i) {
                temp[i] = this.data[i];
            }
	        // dynamically create another array + 1
            this.data = new int[this.top1+1];

	        // copy the elements back to the new allocated array, and add the new element at the top.
            for(int i = 0; i<this.top1;++i){
                this.data[i] = temp[i];
            }
            this.data[this.top1] = x;
            this.top1 += 1;
        }
    }
    public int pull(){
	    if(this.top1 >0) {
            int x = this.data[this.top1-1];
            this.top1 -= 1;
            return x;
        }
	    else{
	        return -1;
        }
    }
    public int top(){
	    if (this.top1>0){
	        return this.data[this.top1-1];
        }
	    else{
	        return -1;
        }
    }
    public boolean isEmpty(){
	    if(this.top1>-1){
	        return false;
        }
	    else{
	        return true;
        }
    }


}
