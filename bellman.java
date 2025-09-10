import java.util.*;
public class bellman 
{
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        int V,E=1,chckNegative=0;
        int W[][]=new int[20][20];
        int edge[][]=new int[50][2];
        System.out.println("Enter the no of vertices");
        V=in.nextInt();
        System.out.println("ENter the weight matrix");
        for(int i=1;i<=V;i++)
            for(int j=1;j<=V;j++)
            {
                W[i][j]=in.nextInt();
                if(W[i][j]!=0){
                    edge[E][0]=i;
                    edge[E++][1]=j;

                }
            }
            chckNegative=belimanFord(W,V,E,edge);
            if(chckNegative==1)
            System.out.println("\n No NEgative weight cycle\n");
            else
            System.out.println("\n Negative weight cycle exists\n");
        }
        public static int belimanFord(int W[][],int V,int E,int edge[][])
        {
            int u,v,S,flag=1;
            int distance[]=new int[20];
            int parent[]=new int[20];
            for(int i=1;i<=V;i++){
                distance[i]=999;
                parent[i]=-1;
            }
            System.out.println("Enter the source vertex");
            S=in.nextInt();
            distance[S]=0;
            for(int i=1;i<=V-1;i++)
            {
                for(int k=1;k<=E;k++)
                {
                    u=edge[k][0];//I
                    v=edge[k][1];//J
                    if(distance[u]+W[u][v]<distance[v])
                    {
                        distance[v]=distance[u]+W[u][v];
                        parent[v]=u;

                    }
                }
            }
            for(int k=1;k<=E;k++){
                u=edge[k][0];
                v=edge[k][1];
                if(distance[u]+W[u][v]<distance[v])
                flag=0;
            }
            if(flag==1)
            for(int i=1;i<=V;i++)
            System.out.println("Vertex"+i+"->cost="+distance[i]+"parent="+(parent[i]));
            return flag;
            }

        }

    


