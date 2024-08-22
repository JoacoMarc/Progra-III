public class Sumador {
    public int sumar_N_nums(int n , int suma){
        if(n==0){
            return suma;
        }
        else{
            return sumar_N_nums(n-1,n+suma);
        }
    }
}
