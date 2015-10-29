data = csvread('hw1q6.csv')

mean1 = mean(data(:,1));
mean2 = mean(data(:,2));


median1 = median(data(:,1));
median2 = median(data(:,2));


std1 = std(data(:,1));
std2 = std(data(:,2));


mle1 = mle(data(:,1));
mle2 = mle(data(:,2));


range1 = range(data(:,1));
range2 = range(data(:,2));

fprintf('Mean1 = %0.3f\n',mean1)
fprintf('Mean2 = %0.3f\n',mean2)

fprintf('Median1 = %0.3f\n',median1)
fprintf('Median2 = %0.3f\n',median2)

fprintf('Standard Deviation 1 = %0.3f\n',std1)
fprintf('Standard Deviation 2 = %0.3f\n',std2)

fprintf('Maximum likelihood deviation 1 = %0.3f\n',mle1)
fprintf('Maximum likelihood deviation 2 = %0.3f\n',mle2)

fprintf('Range 1 = %0.3f\n',range1)
fprintf('Range 2 = %0.3f\n',range2)

prctile1_0 = prctile(data(:,1), 0);
prctile2_0 = prctile(data(:,2), 0);


fprintf('0 Percentile 1 = %0.3f\n',prctile1_0)
fprintf('0 Percentile 2 = %0.3f\n',prctile2_0)


prctile1_25 = prctile(data(:,1), 25);
prctile2_25 = prctile(data(:,2), 25);


fprintf('25 Percentile 1 = %0.3f\n',prctile1_25)
fprintf('25 Percentile 2 = %0.3f\n',prctile2_25)


prctile1_50 = prctile(data(:,1), 50);
prctile2_50 = prctile(data(:,2), 50);


fprintf('50 Percentile 1 = %0.3f\n',prctile1_50)
fprintf('50 Percentile 2 = %0.3f\n',prctile2_50)

prctile1_75 = prctile(data(:,1), 75);
prctile2_75 = prctile(data(:,2), 75);


fprintf('75 Percentile 1 = %0.3f\n',prctile1_75)
fprintf('75 Percentile 2 = %0.3f\n',prctile2_75)


prctile1_100 = prctile(data(:,1), 100);
prctile2_100 = prctile(data(:,2), 100);


fprintf('100 Percentile 1 = %0.3f\n',prctile1_100)
fprintf('100 Percentile 2 = %0.3f\n',prctile2_100)


hist = zeros(10,1);

figure(1)
histfit(data(:,1),10, 'normal')
title('Histogram and Fit for Column 1')

figure(2)
histfit(data(:,2),10, 'normal')
title('Histogram and Fit for Column 2')

figure(3)
qqplot(data(:,1))
title('Quantile-Quantile Plot - 1')

figure(4)
qqplot(data(:,2))
title('Quantile-Quantile Plot - 2')




