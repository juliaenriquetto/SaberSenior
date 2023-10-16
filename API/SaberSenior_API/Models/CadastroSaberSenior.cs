using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SaberSenior_API.Models
{
    public class CadastroSaberSenior
    {
        public int id {get; set;}
        public string? idFraseSecreta {get;set;}
        public string? nome {get;set;}
        public string? telefone {get;set;}
    }
}