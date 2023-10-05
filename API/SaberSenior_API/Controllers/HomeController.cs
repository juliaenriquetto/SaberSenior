using Microsoft.AspNetCore.Mvc;

namespace SaberSenior_API.AddControllers
{
   [ApiController]
   [Route("/")]
   public class HomeController: ControllerBase
   {
     [HttpGet]
     public ActionResult Inicio()
     {
        return new ContentResult
        {
            ContentType = "text/html", 
            Content = "<h1>API Projeto SaberSenior: Funcionou!</h1>" 
        };
     }
   }
}