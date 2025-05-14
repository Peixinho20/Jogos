using FlipCity.Cartas;

class Program
{
    static void Main(string[] args)
    {
        var carta = new AreaResidencial();
        Console.WriteLine(carta);
        carta.AplicarEfeito();
    }
}

