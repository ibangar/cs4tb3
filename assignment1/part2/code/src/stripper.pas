program Stripper;
uses SysUtils;

(* functions *)
function removeComments(l : String; var m : Integer): String;
var i : Integer;
var start : Integer;
begin
    if m = 0 then
        start := 0
    else
        start := 1;

    (* start with whole string *)
    removeComments := copy(l, 1, byte(l[0]));

    for i := 1 to (byte(l[0]) - 1) do
    begin
        (* line end comment start / end *)
        if (l[i] = '/') and (l[i+1] = '/') and (m = 0) then
        begin
            delete(removeComments, i, byte(l[0]));
            break;
        end;
        (* start bracket comment *)
        if (l[i] = '/') and (l[i+1] = '*') and (m = 0) then
        begin
            start := i;
            m := 1;
        end;
        (* end bracket comment *)
        if (l[i] = '*') and (l[i+1] = '/') and (m = 1) then
        begin
            if (start <> i - 1) or (start = 1) then
            begin
                delete(removeComments, start, (i+1) - start + 1);
                start := 0;
                m := 0;
                removeComments := removeComments(removeComments, m);
                break;
            end;
        end;
    end;

    (* bracket comment spans lines *)
    if (m = 1) then
        delete(removeComments, start, byte(l[0]));
end;

(* program variables *)
var m : Integer; (* current mode 0 - default, 1 - bracket comment *)
var l, o : String;  (* line input and output *)
var t : String; (* empty string check *)

(* program entry *)
begin
    m := 0;

    repeat
        readln(l);
        if byte(l[0]) > 0 then
            begin
                o := removeComments(l, m);

                (* check if line is just white space *)
                t := Trim(o);
                if (byte(t[0]) > 0) then
                    writeln(o);
            end
        else
            writeln('');
    until Eof();
end.
