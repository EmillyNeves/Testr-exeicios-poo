#ifndef MYSTRING_H
#define MYSTRING_H

#include <cstring> // Usar <cstring> (C++) em vez de <string.h> (C)
#include <cstdio> // <stdio.h>

class String
{
private:
    char *_data;
    int _tam;

public:
    String();

    String(const char *data);
    String(const String &s);
    ~String();
    String& operator=(const String &s);
    String operator+(const String &s2) const;
    const char *c_str() const;
};

String::String() //String x3, x4, x5, x6, defalt
{
    this->_tam = 0;
    this->_data = new char[1]; // espaÃ§o caractere nulo
    this->_data[0] = '\0';
}

String::String(const char *data)   //String x1(s1), parametro
{
    if (data == nullptr)
    {
        this->_tam = 0;
        this->_data = new char[1];
        this->_data[0] = '\0';
    }
    else
    {
        this->_tam = strlen(data); //alocar pois nao se sabe o tam da string
        this->_data = new char[this->_tam + 1]; // +1 para o caractere nulo '\0'
        strcpy(this->_data, data);
    }
}

String::String(const String &s) //String x2(x1), copia
{
    _tam = s._tam;
    _data = new char[_tam + 1];
    strcpy(_data, s._data);
}

String::~String()
{
    delete[] this->_data;
}

String& String::operator=(const String &s) // x4 = x3 = x3 e x3 = (String(s2)parametro),
{
    if (this == &s) {
        return *this;
    }
    delete[] this->_data;

    this->_tam = s._tam;
    this->_data = new char[this->_tam + 1];
    strcpy(this->_data, s._data);

    return *this;
}

String String::operator+(const String &s2) const // x5 = x1 + x2;
{

    int novo_tam = this->_tam + s2._tam;
    char* buffer = new char[novo_tam + 1];

    strcpy(buffer, this->_data);

    strcat(buffer, s2._data);

    String nova_s(buffer);

    delete[] buffer;

    return nova_s;
}

const char *String::c_str() const
{
    return this->_data;
}

#endif