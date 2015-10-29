SizeXTest = size(X_test);
XTestInstance = SizeXTest(1);
XTestAttributes = SizeXTest(2);

SizeXTrain= size(X_train);
XTrainInstance = SizeXTrain(1);
XTrainAttributes = SizeXTrain(2);

UniqueYTest = unique(Y_test);
UniqueYTestCount = size(UniqueYTest);

UniqueYTrain = unique(Y_train);
UniqueYTrainCount = size(UniqueYTrain);

MeanXTest = mean(X_test);
MeanXTrain = mean(X_train);

X_test_new = X_test;
X_train_new = X_train;

for i=1:XTestAttributes
    X_test_new(:,i) = X_test(:,i) - MeanXTest(i);
    X_train_new(:,i) = X_train(:,i) - MeanXTrain(i); 
end

cov_X_test_new = cov(X_test_new);
cov_X_train_new = cov(X_train_new);


%eigVal_x_test = eig(cov_X_test_new);
%[eigVal_x_test_vec, eigVal_x_test_diag] = eig(cov_X_test_new); 
eigVal_x_train = eig(cov_X_train_new);
[eigVal_x_train_vec, eigVal_x_train_diag] = eig(cov_X_train_new);
k=0;
for j=[2 4 6 8 10 20 30 40 50 60]
k = k + 1;
reduced_test_data = X_test_new * eigVal_x_train_vec(:,65-j:64);
reduced_train_data = X_train_new * eigVal_x_train_vec(:,65-j:64);

t = classregtree(reduced_train_data, Y_train);

count(k) = 0;
for i=1:size(X_test)
    temp = round(eval(t, reduced_test_data(i,:)));
    if temp == Y_test(i)
        count(k) = count(k) + 1;
    end
end

scale(k) = j;
j
count(k)
accuracy(k) = (count(k) / 1000) * 100

end
    
plot(scale, accuracy)
xlabel('Number of Dimensions')
ylabel('Accuracy in %')
title('Plot of Accuracy vs Number of Dimensions')

    
