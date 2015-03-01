program Test1;
var check : Integer;
begin
    hello := 5;

    if check < hello then
    begin
        call()
    end;

    if check < hello then
        call2();

    while check > hello do
    begin
        if check = hello then
        begin
            call3()
        end;
    end;
end;
