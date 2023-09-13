using System.Collections.Generic; 
using System.Linq; 
using System.Threading.Tasks; 
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc; 
using SaberSenior_API.Data;
using SaberSenior_API.Models;

namespace SaberSenior_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CadastroController:ControllerBase
    {
    private CadastroContext _context;

    public CadastroController(CadastroContext context)
    {
        //construtor 
        _context = context;
    }

    //CRUD
    [HttpGet]
     public ActionResult<List<CadastroSaberSenior>> GetAll()
     {
        return _context.CadastroSaberSenior.ToList(); 
     }
    }
}