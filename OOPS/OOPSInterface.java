class OOPSInterface{
    public static void main (String args[]){
        Queen q = new Queen();
        q.moves();
    }
}

interface ChessPlayers
{
    abstract void moves();
}

class Queen implements ChessPlayers
{
    public void moves();
    {
        System.out.println("up,down,right,left,diagonal");
    }
}

class Rook implements ChessPlayers
{
    public void moves();
    {
        System.out.println("up,down,right,leftl");
    }
}