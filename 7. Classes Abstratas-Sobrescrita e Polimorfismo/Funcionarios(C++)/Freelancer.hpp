
#ifndef _FREELANCER_HPP_
#define _FREELANCER_HPP_
#include <string>
#include "Funcionario.hpp"
class Freelancer : public Funcionario
{
private:
    int _h_trabalhadas;
    double _valor_hora;

public:
    Freelancer(std::string n, int h, double v);
    double salario() override;
    ~Freelancer();
};
#endif // _FREELANCER_HPP_
