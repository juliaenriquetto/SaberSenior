using Microsoft.EntityFrameworkCore; 
using SaberSenior_API.Models;
using System.Diagnostics.CodeAnalysis;

namespace SaberSenior_API.Data{
     public class CadastroContext : DbContext
    {
       protected readonly IConfiguration Configuration;
      public CadastroContext(IConfiguration configuration)
       {
         Configuration = configuration; 
       }

       protected override void OnConfiguring(DbContextOptionsBuilder options)
       {
        //connect to sql server with connection string from app settings
        options.UseSqlServer(Configuration.GetConnectionString("StringConexaoSQLServer")); 
       }

      public DbSet<CadastroSaberSenior> CadastroSaberSenior {get; set;}
    }
}