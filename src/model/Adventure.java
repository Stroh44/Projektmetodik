package model;

public class Adventure {

    private int level;

    private int startPosition;
    private int startPositionX;
    private int startPositionY;
    private Room rooms;

    public Adventure(int level,int startPosition) {

        this.level = level;
        this.startPosition=startPosition;
        getStartingPositions();


        this.rooms = new Room(startPositionX,startPositionY,level);

    }


    /*This function sets the starting position of the character based on what level(1,2,3) you choose and which startPosition(1,2,3,4) you selected
    Example: if constructor gets 1,2 you will get this layout of rooms and you will spawn where the 2 is located
        3XX4
        XXXX
        1XX2

     */
    public void getStartingPositions(){

        //level 1= 4x4 rooms
        if(this.level==1) {
            if (this.startPosition == 1) {
                this.startPositionX = 0;
                this.startPositionY = 0;


            }
            if (this.startPosition == 2) {
                this.startPositionX = 0;
                this.startPositionY = 3;

            }
            if (this.startPosition == 3) {
                this.startPositionX = 3;
                this.startPositionY = 0;

            }
            if (this.startPosition == 4) {
                this.startPositionX = 3;
                this.startPositionY = 3;

            }
        }
            //level 2= 5x5 rooms
        if(this.level==2){
            if(this.startPosition==1){
                this.startPositionX=0;
                this.startPositionY=0;


            }
            if(this.startPosition==2){
                this.startPositionX=0;
                this.startPositionY=4;

            }
            if(this.startPosition==3){
                this.startPositionX=4;
                this.startPositionY=0;

            }
            if(this.startPosition==4){
                this.startPositionX=4;
                this.startPositionY=4;

            }
        }

        //level 3= 8x8 rooms
        if(this.level==3){
            if(this.startPosition==1){
                this.startPositionX=0;
                this.startPositionY=0;


            }
            if(this.startPosition==2){
                this.startPositionX=0;
                this.startPositionY=7;

            }
            if(this.startPosition==3){
                this.startPositionX=7;
                this.startPositionY=0;

            }
            if(this.startPosition==4){
                this.startPositionX=7;
                this.startPositionY=7;

            }
        }


    }


}