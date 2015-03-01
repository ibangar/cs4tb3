program arithmetic;

  var x, y, v: integer;

  procedure Pow (x, y: integer; var v: integer);
  begin
    v := x^3^2;
  end;

begin
  x := 2;
  y := 2;
  Pow (x, y, v);
  write(v);
end.
