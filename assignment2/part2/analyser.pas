program analyser;
uses scanner;
begin
    GetSym;
    while not (sym = EofSym) do
    begin
        GetSym;
    end;
end.
