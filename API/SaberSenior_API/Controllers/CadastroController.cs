using Microsoft.AspNetCore.Mvc;
using SaberSenior_API.Data;
using SaberSenior_API.Models;

namespace SaberSenior_API.Controllers
{
    //crud
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

        [HttpGet]
        public ActionResult<List<CadastroSaberSenior>> GetAll()
        {
            return _context.CadastroSaberSenior.ToList();
        }

        [HttpGet("{CadastroId}")]
         public ActionResult<CadastroSaberSenior> Get(int CadastroId)
        {
            try
            {
                var result = _context.CadastroSaberSenior.Find(CadastroId);
                if(result == null)
                {
                    return NotFound(); 
                 }
             return Ok(result);
            }
            catch
            {
             return this.StatusCode(StatusCodes.Status500InternalServerError, "Falha no acesso ao banco de dados.");
            }
        }
        
        [HttpPost]
        public async Task<ActionResult> post(CadastroSaberSenior model)
        {
            try{
                _context.CadastroSaberSenior.Add(model);
                if(await _context.SaveChangesAsync() == 1)
                {                        
                    //return Ok()
                    return Created($"/api/cadastro/{model.idFraseSecreta}", model); 
                }
            }
            catch{
               return this.StatusCode(StatusCodes.Status500InternalServerError, "Falha no acesso ao banco de dados");   
            }

            return BadRequest();
        }

     [HttpDelete("{CadastroId}")]
      public async Task<ActionResult> delete(int CadastroId)
      {
        try{
         //verifica se existe o usuario no cadastro, a ser excluido 
         var usuario = await _context.CadastroSaberSenior.FindAsync(CadastroId);
         if(usuario == null)
         {
            //método do EF
            return NotFound(); 
         }
         _context.Remove(usuario);
         await _context.SaveChangesAsync(); 
         return NoContent();
        }
        catch{
         return this.StatusCode(StatusCodes.Status500InternalServerError, "Falha no acesso ao banco de dados.");
        }
      }
     
     
   [HttpPut("{CadastroId}")]
     public async Task<IActionResult> put(int CadastroId, CadastroSaberSenior dadosCadastroAlt)
     {
      try{
        //verifica se existe usuario a ser alterado no bd cadastro
        var result = await _context.CadastroSaberSenior.FindAsync(CadastroId);
        if(CadastroId != result.id)
        {
         return BadRequest(); 
        }
        result.idFraseSecreta = dadosCadastroAlt.idFraseSecreta;
        result.nome = dadosCadastroAlt.nome;
        result.telefone = dadosCadastroAlt.telefone;
        await _context.SaveChangesAsync();
        return Created($"/api/cadastro/{dadosCadastroAlt.idFraseSecreta}", dadosCadastroAlt);
      }
      catch{
         return this.StatusCode(StatusCodes.Status500InternalServerError, "Falha no acesso ao banco de dados.");
      }
     }
    }
}