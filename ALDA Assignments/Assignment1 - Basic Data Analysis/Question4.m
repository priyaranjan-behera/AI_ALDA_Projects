meanA = 5;
varianceA = 1;
A = randn(4,4)*varianceA+meanA;

A(2:2:4, :)

Sum3rdRow = sum(A(3,:));
Sum4thColumn = sum(A(:,4));
SumDiag = sum(diag(A));
sumA = Sum3rdRow + Sum4thColumn + SumDiag

sumMat = 0;
for m = 1:4
    for n = 1:4
        sumMat = sumMat + A(m,n);
    end
end
sumMat


X = [2 3 4 5];
B = diag(X)

C = zeros(4);
for m=1:4
    C(m,:) = m+1;
end

multipleA = A.*C
multipleB = B.*C

for m=1:4
    C(:,m) = m+1;
end

multipleA = A.*C
multipleB = B.*C




X = [1; 2; 3; 4];
Y = [9; 6; 4; 1];

C1 = cov(X,Y)

Xmean = [2.5; 2.5; 2.5; 2.5];
Ymean = [5; 5; 5; 5];
XY = [X, Y];
XYmean = [Xmean, Ymean];
XYDiff = XY - XYmean;
C2 = (XYDiff' * XYDiff) / 3



XSquare = X.^2;
mean(mean(XSquare))

mean(X)^2 + var(X)
